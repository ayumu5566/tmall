package tmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tmall.bean.Property;
import tmall.util.DBUtil;

/**
 * ����DAO
 * 
 * @author ZhanShiLun
 * @date 2017��9��6�� ����4:09:54
 *
 */
public class PropertyDAO {

	/**
	 * ����
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:57:00
	 * @param bean
	 *            ����
	 */
	public void add(Property bean) {
		String sql = "INSERT INTO property VALUES (null, ?, ?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			// ���ò���
			ps.setInt(1, bean.getCid());
			ps.setString(2, bean.getName());

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
	 *            ����ID
	 */
	public void delete(int id) {
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
			String sql = "DELETE FROM property p WHERE p.id = " + id;
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
	 *            ����
	 */
	public void update(Property bean) {
		String sql = "UPDATE property p SET p.cid = ?, p.name = ? WHERE p.id = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, bean.getCid());
			ps.setString(2, bean.getName());
			ps.setInt(3, bean.getId());
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
	 *            ����ID
	 */
	public Property get(int id) {
		Property property = null;
		String sql = "SELECT p.id, p.cid, p.name FROM property p WHERE p.id = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, id);
			ps.execute();
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				property = new Property();
				property.setId(rs.getInt(1));
				property.setCid(rs.getInt(2));
				property.setName(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return property;
	}

	/**
	 * ����id��ȡ
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:57:21
	 * @param id
	 *            ����ID
	 */
	public Property get(int id, String name) {
		Property property = null;
		String sql = "SELECT p.id, p.cid, p.name FROM property p WHERE p.id = ? and p.name = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.execute();
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				property = new Property();
				property.setId(rs.getInt(1));
				property.setCid(rs.getInt(2));
				property.setName(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return property;
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
		String sql = "SELECT COUNT(1) FROM property";
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
	 * ��ѯĳ�������µĵ����Զ��󣨲���ҳ��
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����4:22:32
	 * @param cid
	 *            ����ID
	 * @return
	 */
	public List<Property> list(int cid) {
		return list(cid, 0, Short.MAX_VALUE);
	}

	/**
	 * ��ѯĳ�������µĵ����Զ��󣨷�ҳ��
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����4:22:09
	 * @param cid
	 *            ����ID
	 * @param start
	 *            ��ʼ����
	 * @param count
	 *            ��ʾ����
	 * @return
	 */
	public List<Property> list(int cid, int start, int count) {
		List<Property> beans = new ArrayList<Property>();

		String sql = "SELECT p.id, p.cid, p.name FROM property p where p.cid = ? order by id desc LIMIT ?, ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, cid);
			ps.setInt(2, start);
			ps.setInt(3, count);

			ps.execute();

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Property property = new Property();
				property.setId(rs.getInt(1));
				property.setCid(rs.getInt(2));
				property.setName(rs.getString(3));
				beans.add(property);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return beans;
	}
}
