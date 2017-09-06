package tmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tmall.bean.User;
import tmall.util.DBUtil;

/**
 * �û�DAO
 * 
 * @author ZhanShiLun
 * @date 2017��9��6�� ����3:47:35
 *
 */
public class UserDAO {

	/**
	 * ����
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����3:47:24
	 * @param bean
	 *            �û�
	 */
	public void add(User bean) {
		String sql = "INSERT INTO user VALUES (null, ?, ?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			// ���ò���
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getPassword());

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
	 *            �û�ID
	 */
	public void delete(int id) {
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
			String sql = "DELETE FROM user u WHERE u.id = " + id;
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
	 *            �û�
	 */
	public void update(User bean) {
		String sql = "UPDATE user u SET u.name = ?, u.password = ? WHERE u.id = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getPassword());
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
	 *            �û�ID
	 */
	public User get(int id) {
		User user = null;
		String sql = "SELECT u.id, u.name, u.password FROM user u WHERE u.id = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, id);
			ps.execute();
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * �����û�����ȡ
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����3:55:47
	 * @param name
	 *            �û���
	 */
	public User get(String name) {
		User user = null;
		String sql = "SELECT u.id, u.name, u.password FROM user u WHERE u.name = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setString(1, name);
			ps.execute();
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * �����û��������ȡ
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����3:56:21
	 * @param name
	 *            �û���
	 * @param password
	 *            ����
	 */
	public User get(String name, String password) {
		User user = null;
		String sql = "SELECT u.id, u.name, u.password FROM user u WHERE u.name = ? and u.password = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setString(1, name);
			ps.setString(2, password);
			ps.execute();
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * ��ҳ��ѯ����ҳ��
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:57:26
	 * @param start
	 *            ��ʼ����
	 * @param count
	 *            ��ʾ����
	 * @return
	 */
	public List<User> list(int start, int count) {
		List<User> beans = new ArrayList<User>();

		String sql = "SELECT u.id, u.name, u.password FROM user u LIMIT ?, ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, start);
			ps.setInt(2, count);

			ps.execute();

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setPassword(rs.getString(3));
				beans.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return beans;
	}

	/**
	 * ��ѯ���У�����ҳ��
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:57:33
	 * @return
	 */
	public List<User> list() {
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
		String sql = "SELECT COUNT(1) FROM user";
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
	 * �����û����ж��Ƿ����
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����4:04:21
	 * @param name
	 *            �û���
	 * @return
	 */
	public boolean isExist(String name) {
		User user = get(name);
		return user != null;
	}
}
