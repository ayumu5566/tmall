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
 * 用户DAO
 * 
 * @author ZhanShiLun
 * @date 2017年9月6日 下午3:47:35
 *
 */
public class UserDAO {

	/**
	 * 新增
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午3:47:24
	 * @param bean
	 *            用户
	 */
	public void add(User bean) {
		String sql = "INSERT INTO user VALUES (null, ?, ?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			// 设置参数
			ps.setString(1, bean.getName());
			ps.setString(2, bean.getPassword());

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
	 *            用户ID
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
	 * 修改
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:57:14
	 * @param bean
	 *            用户
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
	 * 根据id获取
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:57:21
	 * @param id
	 *            用户ID
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
	 * 根据用户名获取
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午3:55:47
	 * @param name
	 *            用户名
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
	 * 根据用户名密码获取
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午3:56:21
	 * @param name
	 *            用户名
	 * @param password
	 *            密码
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
	 * 分页查询（分页）
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:57:26
	 * @param start
	 *            开始条数
	 * @param count
	 *            显示数量
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
	 * 查询所有（不分页）
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:57:33
	 * @return
	 */
	public List<User> list() {
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
	 * 根据用户名判断是否存在
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午4:04:21
	 * @param name
	 *            用户名
	 * @return
	 */
	public boolean isExist(String name) {
		User user = get(name);
		return user != null;
	}
}
