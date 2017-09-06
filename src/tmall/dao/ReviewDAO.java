package tmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tmall.bean.Review;
import tmall.util.DBUtil;
import tmall.util.DateUtil;

public class ReviewDAO {

	/**
	 * 增加
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:57:00
	 * @param bean
	 *            评价
	 */
	public void add(Review bean) {
		String sql = "INSERT INTO review VALUES (null, ?, ?, ?, ?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			// 设置参数
			ps.setString(1, bean.getContent());
			ps.setInt(2, bean.getUid());
			ps.setInt(3, bean.getPid());
			ps.setTimestamp(4, DateUtil.d2t(bean.getCreateDate()));

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
	 *            评价ID
	 */
	public void delete(int id) {
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
			String sql = "DELETE FROM review r WHERE r.id = " + id;
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
	 *            评价
	 */
	public void update(Review bean) {
		String sql = "UPDATE review r SET r.content = ?, r.uid = ?, r.pid = ?, p.createDate = ? WHERE r.id = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setString(1, bean.getContent());
			ps.setInt(2, bean.getUid());
			ps.setInt(3, bean.getPid());
			ps.setTimestamp(4, DateUtil.d2t(bean.getCreateDate()));
			ps.setInt(5, bean.getId());
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
	 *            评价ID
	 */
	public Review get(int id) {
		Review review = null;
		String sql = "SELECT r.id, r.content, r.uid, r.pid, r.createDate FROM review r WHERE r.id = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, id);
			ps.execute();
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				review = new Review();
				review.setId(rs.getInt(1));
				review.setContent(rs.getString(2));
				review.setUid(rs.getInt(3));
				review.setPid(rs.getInt(4));
				review.setCreateDate(DateUtil.t2d(rs.getTimestamp("createDate")));
				review.setUser(new UserDAO().get(rs.getInt(3)));
				review.setProduct(new ProductDAO().get(rs.getInt(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return review;
	}

	/**
	 * 获取指定产品的评价（分页）
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:57:26
	 * @param pid
	 *            产品ID
	 * @param start
	 *            开始条数
	 * @param count
	 *            显示数量
	 * @return
	 */
	public List<Review> list(int pid, int start, int count) {
		List<Review> beans = new ArrayList<Review>();

		String sql = "SELECT r.id, r.content, r.uid, r.pid, r.createDate FROM review r WHERE r.pid = ? ORDER BY r.id LIMIT ?, ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, pid);
			ps.setInt(2, start);
			ps.setInt(3, count);

			ps.execute();

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Review review = new Review();
				review.setId(rs.getInt(1));
				review.setContent(rs.getString(2));
				review.setUid(rs.getInt(3));
				review.setPid(rs.getInt(4));
				review.setCreateDate(DateUtil.t2d(rs.getTimestamp("createDate")));
				review.setUser(new UserDAO().get(rs.getInt(3)));
				review.setProduct(new ProductDAO().get(rs.getInt(4)));
				beans.add(review);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return beans;
	}

	/**
	 * 获取指定产品的评价（不分页）
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午5:30:48
	 * @param pid
	 *            产品ID
	 * @return
	 */
	public List<Review> list(int pid) {
		return list(pid, 0, Short.MAX_VALUE);
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
		String sql = "SELECT COUNT(1) FROM review";
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
	 * 获取指定产品评价总数
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午5:33:45
	 * @param pid
	 *            产品ID
	 * @return
	 */
	public int getCount(int pid) {
		int total = 0;
		String sql = "SELECT COUNT(1) FROM review r WHERE r.pid = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, pid);
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
	 * 根据条件判断评价是否存在
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午5:38:41
	 * @param content
	 *            内容
	 * @param pid
	 *            产品ID
	 * @return
	 */
	public boolean isExist(String content, int pid) {

		String sql = "SELECT r.id, r.content, r.uid, r.pid, r.createDate FROM review r WHERE r.content = ? AND r.pid = ?";

		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
			ps.setString(1, content);
			ps.setInt(2, pid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}
}
