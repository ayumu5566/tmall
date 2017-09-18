package tmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tmall.bean.Category;
import tmall.bean.Product;
import tmall.bean.ProductImage;
import tmall.util.DBUtil;
import tmall.util.DateUtil;

public class ProductDAO {

	/**
	 * 增加
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:57:00
	 * @param bean
	 *            产品
	 */
	public void add(Product bean) {
		String sql = "INSERT INTO product VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			// 设置参数
			ps.setInt(1, bean.getCid());
			ps.setString(2, bean.getName());
			ps.setString(3, bean.getSubTitle());
			ps.setFloat(4, bean.getOrignalPrice());
			ps.setFloat(5, bean.getPromotePrice());
			ps.setInt(6, bean.getStock());
			ps.setTimestamp(7, DateUtil.d2t(bean.getCreateDate()));

			// 执行sql语句
			ps.execute();

			// 取出结果集
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				bean.setId(id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:57:11
	 * @param id
	 *            产品ID
	 */
	public void delete(int id) {
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
			String sql = "DELETE FROM product WHERE id = " + id;
			s.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 修改
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:57:14
	 * @param bean
	 *            产品
	 */
	public void update(Product bean) {
		String sql = "UPDATE product p SET p.cid = ?, p.name = ?, p.subTitle = ?, p.orignalPrice = ?, p.promotePrice = ?, p.stock = ?, p.createDate = ? WHERE p.id = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, bean.getCid());
			ps.setString(2, bean.getName());
			ps.setString(3, bean.getSubTitle());
			ps.setFloat(4, bean.getOrignalPrice());
			ps.setFloat(5, bean.getPromotePrice());
			ps.setInt(6, bean.getStock());
			ps.setTimestamp(7, DateUtil.d2t(bean.getCreateDate()));
			ps.setInt(8, bean.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据id获取
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:57:21
	 * @param id
	 *            产品ID
	 */
	public Product get(int id) {
		Product product = null;
		String sql = "SELECT p.id, p.cid, p.name, p.subTitle, p.orignalPrice, p.promotePrice, p.stock, p.createDate FROM product p WHERE p.id = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, id);
			ps.execute();
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				product = new Product();
				product.setId(rs.getInt(1));
				product.setCid(rs.getInt(2));
				product.setName(rs.getString(3));
				product.setSubTitle(rs.getString(4));
				product.setOrignalPrice(rs.getFloat(5));
				product.setPromotePrice(rs.getFloat(6));
				product.setStock(rs.getInt(7));
				product.setCreateDate(DateUtil.t2d(rs.getTimestamp(8)));
				product.setCategory(new CategoryDAO().get(rs.getInt(2)));
				setFirstProductImage(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	/**
	 * 查询分类下的产品（分页）
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:57:26
	 * @param cid
	 *            分类ID
	 * @param start
	 *            开始条数
	 * @param count
	 *            显示数量
	 * @return
	 */
	public List<Product> list(int cid, int start, int count) {
		List<Product> beans = new ArrayList<Product>();

		String sql = "SELECT p.id, p.cid, p.name, p.subTitle, p.orignalPrice, p.promotePrice, p.stock, p.createDate FROM product p WHERE p.cid = ? ORDER BY p.id DESC LIMIT ?, ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, cid);
			ps.setInt(2, start);
			ps.setInt(3, count);

			ps.execute();

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setCid(rs.getInt(2));
				product.setName(rs.getString(3));
				product.setSubTitle(rs.getString(4));
				product.setOrignalPrice(rs.getFloat(5));
				product.setPromotePrice(rs.getFloat(6));
				product.setStock(rs.getInt(7));
				product.setCreateDate(DateUtil.t2d(rs.getTimestamp(8)));
				product.setCategory(new CategoryDAO().get(rs.getInt(2)));
				setFirstProductImage(product);
				beans.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return beans;
	}

	/**
	 * 查询分类下的产品（不分页）
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月7日 下午1:51:00
	 * @param cid
	 *            分类ID
	 * @return
	 */
	public List<Product> list(int cid) {
		return list(cid, 0, Short.MAX_VALUE);
	}

	/**
	 * 查询所有产品（分页）
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月7日 下午1:51:10
	 * @param start
	 *            开始条数
	 * @param count
	 *            显示数量
	 * @return
	 */
	public List<Product> list(int start, int count) {
		List<Product> beans = new ArrayList<Product>();

		String sql = "SELECT p.id, p.cid, p.name, p.subTitle, p.orignalPrice, p.promotePrice, p.stock, p.createDate FROM product p ORDER BY p.id DESC LIMIT ?, ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, start);
			ps.setInt(2, count);

			ps.execute();

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setCid(rs.getInt(2));
				product.setName(rs.getString(3));
				product.setSubTitle(rs.getString(4));
				product.setOrignalPrice(rs.getFloat(5));
				product.setPromotePrice(rs.getFloat(6));
				product.setStock(rs.getInt(7));
				product.setCreateDate(DateUtil.t2d(rs.getTimestamp(8)));
				product.setCategory(new CategoryDAO().get(rs.getInt(2)));
				setFirstProductImage(product);
				beans.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return beans;
	}

	/**
	 * 查询所有产品（不分页）
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月7日 下午1:51:38
	 * @return
	 */
	public List<Product> list() {
		return list(0, Short.MAX_VALUE);
	}

	/**
	 * 获取总数
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:57:38
	 * @return
	 */
	public int getTotal() {
		int total = 0;
		String sql = "SELECT COUNT(1) FROM product";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.execute();
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				total = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}

	/**
	 * 为分类填充产品集合
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月7日 下午1:52:56
	 * @param c
	 *            分类
	 */
	public void fill(Category c) {
		List<Product> ps = this.list(c.getId());
		c.setProducts(ps);
	}

	/**
	 * 为分类填充产品集合
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月7日 下午1:53:04
	 * @param cs
	 *            分类集合
	 */
	public void fill(List<Category> cs) {
		for (Category c : cs)
			fill(c);
	}

	/**
	 * 为多个分类设置productsByRow属性
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月7日 下午1:54:03
	 * @param cs
	 */
	public void fillByRow(List<Category> cs) {
		int productNumberEachRow = 8;
		for (Category c : cs) {
			List<Product> products = c.getProducts();
			List<List<Product>> productsByRow = new ArrayList<>();
			for (int i = 0; i < products.size(); i += productNumberEachRow) {
				int size = i + productNumberEachRow;
				size = size > products.size() ? products.size() : size;
				List<Product> productsOfEachRow = products.subList(i, size);
				productsByRow.add(productsOfEachRow);
			}
			c.setProductsByRow(productsByRow);
		}
	}

	/**
	 * 一个产品有多个图片，但是只有一个主图片，把第一个图片设置为主图片
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月7日 下午1:55:49
	 * @param product
	 *            产品
	 */
	public void setFirstProductImage(Product product) {
		List<ProductImage> pis = new ProductImageDAO().list(product, ProductImageDAO.type_single);
		if (!pis.isEmpty())
			product.setFirstProductImage(pis.get(0));
	}

	/**
	 * 为产品设置销售和评价数量
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月7日 下午1:57:21
	 * @param p
	 *            产品
	 */
	public void setSaleAndReviewNumber(Product p) {
		int saleCount = new OrderItemDAO().getSaleCount(p.getId());
		p.setSaleCount(saleCount);

		int reviewCount = new ReviewDAO().getCount(p.getId());
		p.setReviewCount(reviewCount);
	}

	/**
	 * 为产品设置销售和评价数量
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月7日 下午1:57:26
	 * @param products
	 *            产品集合
	 */
	public void setSaleAndReviewNumber(List<Product> products) {
		for (Product product : products) {
			setSaleAndReviewNumber(product);
		}
	}

	/**
	 * 根据关键字查询产品
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月7日 下午2:08:32
	 * @param keyword
	 *            关键字
	 * @param start
	 *            开始条数
	 * @param count
	 *            显示数量
	 * @return
	 */
	public List<Product> search(String keyword, int start, int count) {
		List<Product> beans = new ArrayList<Product>();
		if (null == keyword || 0 == keyword.trim().length()) {
			return beans;
		}
		String sql = "SELECT p.id, p.cid, p.name, p.subTitle, p.orignalPrice, p.promotePrice, p.stock, p.createDate FROM product p WHERE p.name LIKE ? ORDER BY p.id DESC LIMIT ?, ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setString(1, "%" + keyword + "%");
			ps.setInt(2, start);
			ps.setInt(3, count);
			ps.execute();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt(1));
				product.setCid(rs.getInt(2));
				product.setName(rs.getString(3));
				product.setSubTitle(rs.getString(4));
				product.setOrignalPrice(rs.getFloat(5));
				product.setPromotePrice(rs.getFloat(6));
				product.setStock(rs.getInt(7));
				product.setCreateDate(DateUtil.t2d(rs.getTimestamp(8)));
				product.setCategory(new CategoryDAO().get(rs.getInt(2)));
				setFirstProductImage(product);
				beans.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return beans;
	}

	/**
	 * 查询指定分类产品个数
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月14日 下午4:19:02
	 * @param cid
	 *            分类ID
	 * @return
	 */
	public int getCountByCategory(int cid) {
		int count = 0;
		String sql = "SELECT count(1) FROM product p where p.cid = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, cid);

			ps.execute();

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
