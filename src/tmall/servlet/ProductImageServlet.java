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

import tmall.bean.Product;
import tmall.bean.ProductImage;
import tmall.dao.ProductImageDAO;
import tmall.util.ImageUtil;
import tmall.util.Page;

public class ProductImageServlet extends BaseBackServlet {

	/**
	 * 序列化的版本号
	 */
	private static final long serialVersionUID = 1121826935299163002L;

	@Override
	public String add(HttpServletRequest request, HttpServletResponse response, Page page) {
		Map<String, String> params = new HashMap<>();
		InputStream is = super.parseUpload(request, params);

		int pid = Integer.parseInt(params.get("pid"));
		String type = params.get("type");

		ProductImage productImage = new ProductImage();
		productImage.setPid(pid);
		productImage.setType(type);
		productImageDAO.add(productImage);

		// 生成文件
		String fileName = productImage.getId() + ".jpg";
		// 正常
		String imageFolder = null;
		// 中
		String imageFolder_middle = null;
		// 小
		String imageFolder_small = null;
		if (ProductImageDAO.type_single.equals(productImage.getType())) {
			imageFolder = request.getSession().getServletContext().getRealPath("img/productSingle");
			imageFolder_middle = request.getSession().getServletContext().getRealPath("img/productSingle_middle");
			imageFolder_small = request.getSession().getServletContext().getRealPath("img/productSingle_small");
		} else {
			imageFolder = request.getSession().getServletContext().getRealPath("img/productDetail");
		}

		File file = new File(imageFolder, fileName);
		file.getParentFile().mkdirs();

		// 复制文件
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

					if (ProductImageDAO.type_single.equals(productImage.getType())) {
						File f_middle = new File(imageFolder_middle, fileName);
						File f_small = new File(imageFolder_small, fileName);

						ImageUtil.resizeImage(file, 56, 56, f_small);
						ImageUtil.resizeImage(file, 217, 190, f_middle);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "@admin_productImage_list?pid=" + productImage.getPid();
	}

	@Override
	public String delete(HttpServletRequest request, HttpServletResponse response, Page page) {
		int id = Integer.parseInt(request.getParameter("id"));
		ProductImage productImage = productImageDAO.get(id);
		productImageDAO.delete(id);

		if (ProductImageDAO.type_single.equals(productImage.getType())) {
			String imageFolder_single = request.getSession().getServletContext().getRealPath("img/productSingle");
			String imageFolder_middle = request.getSession().getServletContext()
					.getRealPath("img/productSingle_middle");
			String imageFolder_small = request.getSession().getServletContext().getRealPath("img/productSingle_small");

			File f_single = new File(imageFolder_single, productImage.getId() + ".jpg");
			File f_middle = new File(imageFolder_middle, productImage.getId() + ".jpg");
			File f_small = new File(imageFolder_small, productImage.getId() + ".jpg");

			f_single.delete();
			f_middle.delete();
			f_small.delete();
		} else {
			String imageFolder = request.getSession().getServletContext().getRealPath("img/productDetail");
			File f_detail = new File(imageFolder, productImage.getId() + ".jpg");
			f_detail.delete();
		}
		return "@admin_productImage_list?pid=" + productImage.getPid();
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
		int pid = Integer.parseInt(request.getParameter("pid"));
		Product product = productDAO.get(pid);

		List<ProductImage> singleImages = productImageDAO.list(product, ProductImageDAO.type_single, page.getStart(),
				page.getCount());
		List<ProductImage> detailImages = productImageDAO.list(product, ProductImageDAO.type_detail, page.getStart(),
				page.getCount());

		request.setAttribute("product", product);
		request.setAttribute("singleImages", singleImages);
		request.setAttribute("detailImages", detailImages);

		return "admin/listProductImage.jsp";
	}

}
