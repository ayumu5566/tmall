package tmall.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import tmall.dao.CategoryDAO;
import tmall.dao.OrderDAO;
import tmall.dao.OrderItemDAO;
import tmall.dao.ProductDAO;
import tmall.dao.ProductImageDAO;
import tmall.dao.PropertyDAO;
import tmall.dao.PropertyValueDAO;
import tmall.dao.ReviewDAO;
import tmall.dao.UserDAO;
import tmall.util.Page;

public abstract class BaseBackServlet extends HttpServlet {

	/**
	 * 序列化的版本号
	 */
	private static final long serialVersionUID = 3361865093716916455L;

	public abstract String add(HttpServletRequest request, HttpServletResponse response, Page page);

	public abstract String delete(HttpServletRequest request, HttpServletResponse response, Page page);

	public abstract String edit(HttpServletRequest request, HttpServletResponse response, Page page);

	public abstract String update(HttpServletRequest request, HttpServletResponse response, Page page);

	public abstract String list(HttpServletRequest request, HttpServletResponse response, Page page);

	protected CategoryDAO categoryDAO = new CategoryDAO();
	protected OrderDAO orderDAO = new OrderDAO();
	protected OrderItemDAO orderItemDAO = new OrderItemDAO();
	protected ProductDAO productDAO = new ProductDAO();
	protected ProductImageDAO productImageDAO = new ProductImageDAO();
	protected PropertyDAO propertyDAO = new PropertyDAO();
	protected PropertyValueDAO propertyValueDAO = new PropertyValueDAO();
	protected ReviewDAO reviewDAO = new ReviewDAO();
	protected UserDAO userDAO = new UserDAO();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			/* 获取分页信息 */
			int start = 0;
			int count = 5;
			try {
				start = Integer.parseInt(request.getParameter("page.start"));
			} catch (Exception e) {

			}
			try {
				count = Integer.parseInt(request.getParameter("page.count"));
			} catch (Exception e) {
			}
			Page page = new Page(start, count);
			/* 借助反射，调用对应的方法 */
			String method = (String) request.getAttribute("method");
			Method m;
			m = this.getClass().getMethod(method, HttpServletRequest.class, HttpServletResponse.class, Page.class);
			String redirect = m.invoke(this, request, response, page).toString();
			/* 根据方法的返回值，进行相应的客户端跳转，服务端跳转，或者仅仅是输出字符串 */
			if (redirect.startsWith("@")) {
				// 如果redirect是以@开头的字符串，那么就进行客户端跳转
				response.sendRedirect(redirect.substring(1));
			} else if (redirect.startsWith("%")) {
				// 如果redirect是以%开头的字符串，那么就直接输出字符串
				response.getWriter().print(redirect.substring(1));
			} else {
				// 如果都不是，则进行服务端跳转
				request.getRequestDispatcher(redirect).forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public InputStream parseUpload(HttpServletRequest request, Map<String, String> params) {
		InputStream is = null;
		try {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			// 设置上传文件的大小限制为10M
			factory.setSizeThreshold(1024 * 10240);

			@SuppressWarnings("rawtypes")
			List items = upload.parseRequest(request);
			@SuppressWarnings("rawtypes")
			Iterator iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				if (!item.isFormField()) {
					// item.getInputStream() 获取上传文件的输入流
					is = item.getInputStream();
				} else {
					String paramName = item.getFieldName();
					String paramValue = item.getString();
					paramValue = new String(paramValue.getBytes("ISO-8859-1"), "UTF-8");
					params.put(paramName, paramValue);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return is;
	}

}
