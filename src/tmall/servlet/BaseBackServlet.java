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
	 * ���л��İ汾��
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
			/* ��ȡ��ҳ��Ϣ */
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
			/* �������䣬���ö�Ӧ�ķ��� */
			String method = (String) request.getAttribute("method");
			Method m;
			m = this.getClass().getMethod(method, HttpServletRequest.class, HttpServletResponse.class, Page.class);
			String redirect = m.invoke(this, request, response, page).toString();
			/* ���ݷ����ķ���ֵ��������Ӧ�Ŀͻ�����ת���������ת�����߽���������ַ��� */
			if (redirect.startsWith("@")) {
				// ���redirect����@��ͷ���ַ�������ô�ͽ��пͻ�����ת
				response.sendRedirect(redirect.substring(1));
			} else if (redirect.startsWith("%")) {
				// ���redirect����%��ͷ���ַ�������ô��ֱ������ַ���
				response.getWriter().print(redirect.substring(1));
			} else {
				// ��������ǣ�����з������ת
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
			// �����ϴ��ļ��Ĵ�С����Ϊ10M
			factory.setSizeThreshold(1024 * 10240);

			@SuppressWarnings("rawtypes")
			List items = upload.parseRequest(request);
			@SuppressWarnings("rawtypes")
			Iterator iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				if (!item.isFormField()) {
					// item.getInputStream() ��ȡ�ϴ��ļ���������
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
