package tmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tmall.bean.Product;
import tmall.bean.ProductImage;
import tmall.util.DBUtil;

/**
 * ��ƷͼƬDAO
 * 
 * @author ZhanShiLun
 * @date 2017��9��6�� ����4:28:13
 *
 */
public class ProductImageDAO {

	/**
	 * ����ͼƬ
	 */
	public static final String type_single = "type_single";

	/**
	 * ����ͼƬ
	 */
	public static final String type_detail = "type_detail";

	/**
	 * ����
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:57:00
	 * @param bean
	 *            ��ƷͼƬ
	 */
	public void add(ProductImage bean) {
		String sql = "INSERT INTO productimage VALUES (null, ?, ?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			// ���ò���
			ps.setInt(1, bean.getPid());
			ps.setString(2, bean.getType());

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
	 *            ��ƷͼƬID
	 */
	public void delete(int id) {
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
			String sql = "DELETE FROM productimage pi WHERE pi.id = " + id;
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
	 *            ��ƷͼƬ
	 */
	public void update(ProductImage bean) {
		// TODO ���޴˹���
	}

	/**
	 * ����id��ȡ
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:57:21
	 * @param id
	 *            ����ID
	 */
	public ProductImage get(int id) {
		ProductImage productImage = null;
		String sql = "SELECT pi.id, pi.pid, pi.type FROM productimage pi WHERE pi.id = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, id);
			ps.execute();
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				productImage = new ProductImage();
				productImage.setId(rs.getInt(1));
				productImage.setPid(rs.getInt(2));
				productImage.setType(rs.getString(3));
				productImage.setProduct(new ProductDAO().get(rs.getInt(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productImage;
	}

	/**
	 * ��ѯָ����Ʒ�£�ĳ�����͵Ĳ�ƷͼƬ����ҳ��
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����4:38:08
	 * @param product
	 *            ��Ʒ
	 * @param type
	 *            ����
	 * @param start
	 *            ��ʼ����
	 * @param count
	 *            ��ʾ����
	 * @return
	 */
	public List<ProductImage> list(Product product, String type, int start, int count) {
		List<ProductImage> beans = new ArrayList<ProductImage>();

		String sql = "SELECT pi.id, pi.pid, pi.type FROM productimage pi WHERE pi.pid = ? AND pi.type = ? ORDER BY pi.id DESC LIMIT ?, ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, product.getId());
			ps.setString(2, type);
			ps.setInt(3, start);
			ps.setInt(2, count);

			ps.execute();

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductImage productImage = new ProductImage();
				productImage.setId(rs.getInt(1));
				productImage.setPid(rs.getInt(2));
				productImage.setType(rs.getString(3));
				productImage.setProduct(product);
				beans.add(productImage);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return beans;
	}

	/**
	 * ��ѯָ����Ʒ�£�ĳ�����͵Ĳ�ƷͼƬ������ҳ��
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:57:33
	 * @return
	 */
	public List<ProductImage> list(Product product, String type) {
		return list(product, type, 0, Short.MAX_VALUE);
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
		String sql = "SELECT COUNT(1) FROM productimage";
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

}
