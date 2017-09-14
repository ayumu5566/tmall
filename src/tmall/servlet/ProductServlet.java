package tmall.servlet;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tmall.bean.Category;
import tmall.bean.Product;
import tmall.util.Page;

public class ProductServlet extends BaseBackServlet {

	/**
	 * 序列化的版本号
	 */
	private static final long serialVersionUID = 8417090897060804893L;

	@Override
	public String add(HttpServletRequest request, HttpServletResponse response, Page page) {
		int cid = Integer.parseInt(request.getParameter("cid"));
		String name = request.getParameter("name");
		String subTitle = request.getParameter("subTitle");
		float orignalPrice = Float.parseFloat(request.getParameter("orignalPrice"));
		float promotePrice = Float.parseFloat(request.getParameter("promotePrice"));
		int stock = Integer.parseInt(request.getParameter("stock"));

		Product product = new Product();

		product.setCid(cid);
		product.setName(name);
		product.setSubTitle(subTitle);
		product.setOrignalPrice(orignalPrice);
		product.setPromotePrice(promotePrice);
		product.setStock(stock);
		product.setCreateDate(new Date());

		productDAO.add(product);
		return "@admin_product_list?cid=" + cid;
	}

	@Override
	public String delete(HttpServletRequest request, HttpServletResponse response, Page page) {
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = productDAO.get(id);
		productDAO.delete(id);
		return "@admin_product_list?cid=" + product.getCid();
	}

	@Override
	public String edit(HttpServletRequest request, HttpServletResponse response, Page page) {
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = productDAO.get(id);
		Category category = categoryDAO.get(product.getCid());
		request.setAttribute("product", product);
		request.setAttribute("category", category);
		return "admin/editProduct.jsp";
	}

	@Override
	public String update(HttpServletRequest request, HttpServletResponse response, Page page) {
		int id = Integer.parseInt(request.getParameter("id"));
		int cid = Integer.parseInt(request.getParameter("cid"));
		String name = request.getParameter("name");
		String subTitle = request.getParameter("subTitle");
		float orignalPrice = Float.parseFloat(request.getParameter("orignalPrice"));
		float promotePrice = Float.parseFloat(request.getParameter("promotePrice"));
		int stock = Integer.parseInt(request.getParameter("stock"));

		Product product = productDAO.get(id);

		product.setName(name);
		product.setSubTitle(subTitle);
		product.setOrignalPrice(orignalPrice);
		product.setPromotePrice(promotePrice);
		product.setStock(stock);
		productDAO.update(product);
		return "@admin_product_list?cid=" + cid;
	}

	@Override
	public String list(HttpServletRequest request, HttpServletResponse response, Page page) {
		int cid = Integer.parseInt(request.getParameter("cid"));
		List<Product> list = productDAO.list(cid, page.getStart(), page.getCount());
		int total = productDAO.getTotal();
		page.setTotal(total);
		page.setParam("%cid=" + cid);
		Category category = categoryDAO.get(cid);

		request.setAttribute("products", list);
		request.setAttribute("category", category);
		request.setAttribute("page", page);

		return "admin/listProduct.jsp";
	}

}
