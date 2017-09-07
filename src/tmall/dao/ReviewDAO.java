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
	 * ����
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:57:00
	 * @param bean
	 *            ����
	 */
	public void add(Review bean) {
		String sql = "INSERT INTO review VALUES (null, ?, ?, ?, ?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			// ���ò���
			ps.setString(1, bean.getContent());
			ps.setInt(2, bean.getUid());
			ps.setInt(3, bean.getPid());
			ps.setTimestamp(4, DateUtil.d2t(bean.getCreateDate()));

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
			String sql = "DELETE FROM review r WHERE r.id = " + id;
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
	 * ����id��ȡ
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:57:21
	 * @param id
	 *            ����ID
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
	 * ��ȡָ����Ʒ�����ۣ���ҳ��
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:57:26
	 * @param pid
	 *            ��ƷID
	 * @param start
	 *            ��ʼ����
	 * @param count
	 *            ��ʾ����
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
	 * ��ȡָ����Ʒ�����ۣ�����ҳ��
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����5:30:48
	 * @param pid
	 *            ��ƷID
	 * @return
	 */
	public List<Review> list(int pid) {
		return list(pid, 0, Short.MAX_VALUE);
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
	 * ��ȡָ����Ʒ��������
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����5:33:45
	 * @param pid
	 *            ��ƷID
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
	 * ���������ж������Ƿ����
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����5:38:41
	 * @param content
	 *            ����
	 * @param pid
	 *            ��ƷID
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
