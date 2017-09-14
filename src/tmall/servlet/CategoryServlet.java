package tmall.servlet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tmall.bean.Category;
import tmall.util.ImageUtil;
import tmall.util.Page;

public class CategoryServlet extends BaseBackServlet {

	/**
	 * 序列化的版本号
	 */
	private static final long serialVersionUID = 6984417886752501534L;

	@Override
	public String add(HttpServletRequest request, HttpServletResponse response, Page page) {
		Map<String, String> params = new HashMap<>();
		InputStream is = super.parseUpload(request, params);

		String name = params.get("name");
		Category category = new Category();
		category.setName(name);
		categoryDAO.add(category);

		File imageFolder = new File(request.getSession().getServletContext().getRealPath("img/category"));
		File file = new File(imageFolder, category.getId() + ".jpg");

		try {
			if (null != is && 0 != is.available()) {
				try (FileOutputStream fos = new FileOutputStream(file)) {
					byte[] b = new byte[1024 * 1024];
					int length = 0;
					while (-1 != (length = is.read(b))) {
						fos.write(b, 0, length);
					}
					fos.flush();
					// 通过如下代码，把文件保存成jpg格式
					BufferedImage image = ImageUtil.change2jpg(file);
					ImageIO.write(image, "jpg", file);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "@admin_category_list";
	}

	@Override
	public String delete(HttpServletRequest request, HttpServletResponse response, Page page) {
		int id = Integer.parseInt(request.getParameter("id"));
		if (!checkCategoryUniqueness(id)) {
			request.setAttribute("msg", "删除失败");
			return "@admin_category_list";
		}
		categoryDAO.delete(id);
		return "@admin_category_list";
	}

	@Override
	public String edit(HttpServletRequest request, HttpServletResponse response, Page page) {
		int id = Integer.parseInt(request.getParameter("id"));
		Category category = categoryDAO.get(id);
		request.setAttribute("category", category);
		return "admin/editCategory.jsp";
	}

	@Override
	public String update(HttpServletRequest request, HttpServletResponse response, Page page) {
		Map<String, String> params = new HashMap<>();
		InputStream is = super.parseUpload(request, params);

		int id = Integer.parseInt(params.get("id"));
		String name = params.get("name");
		Category category = categoryDAO.get(id);
		category.setName(name);
		categoryDAO.update(category);

		File imageFolder = new File(request.getSession().getServletContext().getRealPath("img/category"));
		File file = new File(imageFolder, category.getId() + ".jpg");
		file.getParentFile().mkdirs();

		try {
			if (null != is && 0 != is.available()) {
				try (FileOutputStream fos = new FileOutputStream(file)) {
					byte[] b = new byte[1024 * 1024];
					int length = 0;
					while (-1 != (length = is.read(b))) {
						fos.write(b, 0, length);
					}
					fos.flush();
					// 通过如下代码，把文件保存成jpg格式
					BufferedImage image = ImageUtil.change2jpg(file);
					ImageIO.write(image, "jpg", file);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "@admin_category_list";
	}

	@Override
	public String list(HttpServletRequest request, HttpServletResponse response, Page page) {
		List<Category> cs = categoryDAO.list(page.getStart(), page.getCount());
		int total = categoryDAO.getTotal();
		page.setTotal(total);

		request.setAttribute("thecs", cs);
		request.setAttribute("page", page);
		return "admin/listCategory.jsp";
	}

	/**
	 * 校验分类的唯一性
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月14日 下午4:22:16
	 * @param id
	 *            分类ID
	 * @return
	 */
	public boolean checkCategoryUniqueness(int id) {
		int productCount = productDAO.getCountByCategory(id);
		int propertyCount = propertyDAO.getCountByCategory(id);
		if (productCount != 0 || propertyCount != 0) {
			return false;
		}
		return true;
	}

}
