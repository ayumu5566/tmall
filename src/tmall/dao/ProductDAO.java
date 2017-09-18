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
	 * ����
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:57:00
	 * @param bean
	 *            ��Ʒ
	 */
	public void add(Product bean) {
		String sql = "INSERT INTO product VALUES (null, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			// ���ò���
			ps.setInt(1, bean.getCid());
			ps.setString(2, bean.getName());
			ps.setString(3, bean.getSubTitle());
			ps.setFloat(4, bean.getOrignalPrice());
			ps.setFloat(5, bean.getPromotePrice());
			ps.setInt(6, bean.getStock());
			ps.setTimestamp(7, DateUtil.d2t(bean.getCreateDate()));

			// ִ��sql���
			ps.execute();

			// ȡ�������
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
	 * ɾ��
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:57:11
	 * @param id
	 *            ��ƷID
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
	 * �޸�
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:57:14
	 * @param bean
	 *            ��Ʒ
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
	 * ����id��ȡ
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:57:21
	 * @param id
	 *            ��ƷID
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
	 * ��ѯ�����µĲ�Ʒ����ҳ��
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:57:26
	 * @param cid
	 *            ����ID
	 * @param start
	 *            ��ʼ����
	 * @param count
	 *            ��ʾ����
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
	 * ��ѯ�����µĲ�Ʒ������ҳ��
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��7�� ����1:51:00
	 * @param cid
	 *            ����ID
	 * @return
	 */
	public List<Product> list(int cid) {
		return list(cid, 0, Short.MAX_VALUE);
	}

	/**
	 * ��ѯ���в�Ʒ����ҳ��
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��7�� ����1:51:10
	 * @param start
	 *            ��ʼ����
	 * @param count
	 *            ��ʾ����
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
	 * ��ѯ���в�Ʒ������ҳ��
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��7�� ����1:51:38
	 * @return
	 */
	public List<Product> list() {
		return list(0, Short.MAX_VALUE);
	}

	/**
	 * ��ȡ����
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:57:38
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
	 * Ϊ��������Ʒ����
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��7�� ����1:52:56
	 * @param c
	 *            ����
	 */
	public void fill(Category c) {
		List<Product> ps = this.list(c.getId());
		c.setProducts(ps);
	}

	/**
	 * Ϊ��������Ʒ����
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��7�� ����1:53:04
	 * @param cs
	 *            ���༯��
	 */
	public void fill(List<Category> cs) {
		for (Category c : cs)
			fill(c);
	}

	/**
	 * Ϊ�����������productsByRow����
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��7�� ����1:54:03
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
	 * һ����Ʒ�ж��ͼƬ������ֻ��һ����ͼƬ���ѵ�һ��ͼƬ����Ϊ��ͼƬ
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��7�� ����1:55:49
	 * @param product
	 *            ��Ʒ
	 */
	public void setFirstProductImage(Product product) {
		List<ProductImage> pis = new ProductImageDAO().list(product, ProductImageDAO.type_single);
		if (!pis.isEmpty())
			product.setFirstProductImage(pis.get(0));
	}

	/**
	 * Ϊ��Ʒ�������ۺ���������
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��7�� ����1:57:21
	 * @param p
	 *            ��Ʒ
	 */
	public void setSaleAndReviewNumber(Product p) {
		int saleCount = new OrderItemDAO().getSaleCount(p.getId());
		p.setSaleCount(saleCount);

		int reviewCount = new ReviewDAO().getCount(p.getId());
		p.setReviewCount(reviewCount);
	}

	/**
	 * Ϊ��Ʒ�������ۺ���������
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��7�� ����1:57:26
	 * @param products
	 *            ��Ʒ����
	 */
	public void setSaleAndReviewNumber(List<Product> products) {
		for (Product product : products) {
			setSaleAndReviewNumber(product);
		}
	}

	/**
	 * ���ݹؼ��ֲ�ѯ��Ʒ
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��7�� ����2:08:32
	 * @param keyword
	 *            �ؼ���
	 * @param start
	 *            ��ʼ����
	 * @param count
	 *            ��ʾ����
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
	 * ��ѯָ�������Ʒ����
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��14�� ����4:19:02
	 * @param cid
	 *            ����ID
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
