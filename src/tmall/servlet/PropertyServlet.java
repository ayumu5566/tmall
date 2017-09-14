package tmall.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tmall.bean.Category;
import tmall.bean.Property;
import tmall.util.Page;

public class PropertyServlet extends BaseBackServlet {

	/**
	 * 序列化的版本号
	 */
	private static final long serialVersionUID = 4071522054656427484L;

	@Override
	public String add(HttpServletRequest request, HttpServletResponse response, Page page) {
		int cid = Integer.parseInt(request.getParameter("cid"));
		String name = request.getParameter("name");

		Property property = new Property();
		property.setCid(cid);
		property.setName(name);

		propertyDAO.add(property);
		return "@admin_property_list?cid=" + cid;
	}

	@Override
	public String delete(HttpServletRequest request, HttpServletResponse response, Page page) {
		int id = Integer.parseInt(request.getParameter("id"));
		Property property = propertyDAO.get(id);
		propertyDAO.delete(id);
		return "@admin_property_list?cid=" + property.getCid();
	}

	@Override
	public String edit(HttpServletRequest request, HttpServletResponse response, Page page) {
		int id = Integer.parseInt(request.getParameter("id"));
		Property property = propertyDAO.get(id);
		request.setAttribute("property", property);
		Category category = categoryDAO.get(property.getCid());
		request.setAttribute("category", category);
		return "admin/editProperty.jsp";
	}

	@Override
	public String update(HttpServletRequest request, HttpServletResponse response, Page page) {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		Property property = propertyDAO.get(id);
		property.setName(name);
		propertyDAO.update(property);
		return "@admin_property_list?cid=" + property.getCid();
	}

	@Override
	public String list(HttpServletRequest request, HttpServletResponse response, Page page) {
		int cid = Integer.parseInt(request.getParameter("cid"));
		Category category = categoryDAO.get(cid);
		List<Property> list = propertyDAO.list(cid, page.getStart(), page.getCount());

		int total = propertyDAO.getTotal();
		page.setTotal(total);
		page.setParam("&cid=" + category.getId());

		request.setAttribute("ps", list);
		request.setAttribute("category", category);
		request.setAttribute("page", page);

		return "admin/listProperty.jsp";
	}

}
