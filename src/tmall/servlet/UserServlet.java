package tmall.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tmall.bean.User;
import tmall.util.Page;

public class UserServlet extends BaseBackServlet {

	/**
	 * ���л��İ汾��
	 */
	private static final long serialVersionUID = 3158956371033418127L;

	@Override
	public String add(HttpServletRequest request, HttpServletResponse response, Page page) {
		return null;
	}

	@Override
	public String delete(HttpServletRequest request, HttpServletResponse response, Page page) {
		return null;
	}

	@Override
	public String edit(HttpServletRequest request, HttpServletResponse response, Page page) {
		return null;
	}

	@Override
	public String update(HttpServletRequest request, HttpServletResponse response, Page page) {
		return null;
	}

	@Override
	public String list(HttpServletRequest request, HttpServletResponse response, Page page) {
		List<User> list = userDAO.list(page.getStart(), page.getCount());
		int total = userDAO.getTotal();
		page.setTotal(total);

		request.setAttribute("us", list);
		request.setAttribute("page", page);
		return "admin/listUser.jsp";
	}

}
