package tmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tmall.bean.Order;
import tmall.util.DBUtil;
import tmall.util.DateUtil;

public class OrderDAO {

	/**
	 * ������
	 */
	public static final String waitPay = "waitPay";

	/**
	 * ������
	 */
	public static final String waitDelivery = "waitDelivery";

	/**
	 * ��ȷ��
	 */
	public static final String waitConfirm = "waitConfirm";

	/**
	 * ������
	 */
	public static final String waitReview = "waitReview";

	/**
	 * �����
	 */
	public static final String finish = "finish";

	/**
	 * ��ɾ��
	 */
	public static final String delete = "delete";

	/**
	 * ����
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:57:00
	 * @param bean
	 *            ����
	 */
	public void add(Order bean) {
		String sql = "INSERT INTO order_ VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			// ���ò���
			ps.setInt(1, bean.getUid());
			ps.setString(2, bean.getOrderCode());
			ps.setString(3, bean.getStatus());
			ps.setString(4, bean.getAddress());
			ps.setString(5, bean.getReceiver());
			ps.setString(6, bean.getMobile());
			ps.setString(7, bean.getPost());
			ps.setString(8, bean.getUserMessage());
			ps.setTimestamp(9, DateUtil.d2t(bean.getPayDate()));
			ps.setTimestamp(10, DateUtil.d2t(bean.getDeliveryDate()));
			ps.setTimestamp(11, DateUtil.d2t(bean.getConfirmDate()));
			ps.setTimestamp(12, DateUtil.d2t(bean.getCreateDate()));

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
			String sql = "DELETE FROM order_ o WHERE o.id = " + id;
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
	public void update(Order bean) {
		String sql = "UPDATE order_ o SET o.uid = ?, o.orderCode = ?, o.status = ?, o.address = ?, o.receiver = ?, o.mobile = ?, o.post = ?, o.userMessage = ?, o.payDate = ?, o.deliveryDate = ?, o.confirmDate = ?, o.createDate = ? WHERE o.id = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, bean.getUid());
			ps.setString(2, bean.getOrderCode());
			ps.setString(3, bean.getStatus());
			ps.setString(4, bean.getAddress());
			ps.setString(5, bean.getReceiver());
			ps.setString(6, bean.getMobile());
			ps.setString(7, bean.getPost());
			ps.setString(8, bean.getUserMessage());
			ps.setTimestamp(9, DateUtil.d2t(bean.getPayDate()));
			ps.setTimestamp(10, DateUtil.d2t(bean.getDeliveryDate()));
			ps.setTimestamp(11, DateUtil.d2t(bean.getConfirmDate()));
			ps.setTimestamp(12, DateUtil.d2t(bean.getCreateDate()));
			ps.setInt(13, bean.getId());
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
	public Order get(int id) {
		Order order = null;
		String sql = "SELECT o.id, o.uid, o.orderCode, o.status, o.address, o.receiver, o.mobile, o.post, o.userMessage, o.payDate, o.deliveryDate, o.confirmDate, o.createDate FROM order_ o WHERE o.id = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, id);
			ps.execute();
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				order = new Order();
				order.setId(rs.getInt(1));
				order.setUid(rs.getInt(2));
				order.setOrderCode(rs.getString(3));
				order.setStatus(rs.getString(4));
				order.setAddress(rs.getString(5));
				order.setReceiver(rs.getString(6));
				order.setMobile(rs.getString(7));
				order.setPost(rs.getString(8));
				order.setUserMessage(rs.getString(9));
				order.setPayDate(DateUtil.t2d(rs.getTimestamp(10)));
				order.setDeliveryDate(DateUtil.t2d(rs.getTimestamp(11)));
				order.setConfirmDate(DateUtil.t2d(rs.getTimestamp(12)));
				order.setCreateDate(DateUtil.t2d(rs.getTimestamp(13)));
				order.setUser(new UserDAO().get(rs.getInt(2)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}

	/**
	 * ��ѯ���ж�����Ϣ����ҳ��
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:57:26
	 * @param start
	 *            ��ʼ����
	 * @param count
	 *            ��ʾ����
	 * @return
	 */
	public List<Order> list(int start, int count) {
		List<Order> beans = new ArrayList<Order>();

		String sql = "SELECT o.id, o.uid, o.orderCode, o.status, o.address, o.receiver, o.mobile, o.post, o.userMessage, o.payDate, o.deliveryDate, o.confirmDate, o.createDate FROM order_ o ORDER BY o.id DESC LIMIT ?, ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, start);
			ps.setInt(2, count);

			ps.execute();

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt(1));
				order.setUid(rs.getInt(2));
				order.setOrderCode(rs.getString(3));
				order.setStatus(rs.getString(4));
				order.setAddress(rs.getString(5));
				order.setReceiver(rs.getString(6));
				order.setMobile(rs.getString(7));
				order.setPost(rs.getString(8));
				order.setUserMessage(rs.getString(9));
				order.setPayDate(DateUtil.t2d(rs.getTimestamp(10)));
				order.setDeliveryDate(DateUtil.t2d(rs.getTimestamp(11)));
				order.setConfirmDate(DateUtil.t2d(rs.getTimestamp(12)));
				order.setCreateDate(DateUtil.t2d(rs.getTimestamp(13)));
				order.setUser(new UserDAO().get(rs.getInt(2)));
				beans.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return beans;
	}

	/**
	 * ��ѯ���ж�����Ϣ������ҳ��
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��7�� ����10:12:18
	 * @return
	 */
	public List<Order> list() {
		return list(0, Short.MAX_VALUE);
	}

	/**
	 * ��ѯָ���û��Ķ�������ҳ��
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��7�� ����10:13:12
	 * @param uid
	 *            �û�ID
	 * @param excludedStatus
	 *            ָ��״̬
	 * @param start
	 *            ��ʼ����
	 * @param count
	 *            ��ʾ����
	 * @return
	 */
	public List<Order> list(int uid, String excludedStatus, int start, int count) {
		List<Order> beans = new ArrayList<Order>();

		String sql = "SELECT o.id, o.uid, o.orderCode, o.status, o.address, o.receiver, o.mobile, o.post, o.userMessage, o.payDate, o.deliveryDate, o.confirmDate, o.createDate FROM order_ o WHERE o.uid = ? and o.status != ? ORDER BY o.id DESC LIMIT ?, ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, uid);
			ps.setString(2, excludedStatus);
			ps.setInt(3, start);
			ps.setInt(4, count);

			ps.execute();

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt(1));
				order.setUid(rs.getInt(2));
				order.setOrderCode(rs.getString(3));
				order.setStatus(rs.getString(4));
				order.setAddress(rs.getString(5));
				order.setReceiver(rs.getString(6));
				order.setMobile(rs.getString(7));
				order.setPost(rs.getString(8));
				order.setUserMessage(rs.getString(9));
				order.setPayDate(DateUtil.t2d(rs.getTimestamp(10)));
				order.setDeliveryDate(DateUtil.t2d(rs.getTimestamp(11)));
				order.setConfirmDate(DateUtil.t2d(rs.getTimestamp(12)));
				order.setCreateDate(DateUtil.t2d(rs.getTimestamp(13)));
				order.setUser(new UserDAO().get(rs.getInt(2)));
				beans.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return beans;
	}

	/**
	 * ��ѯָ���û��Ķ���������ҳ��
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��7�� ����10:13:54
	 * @param uid
	 *            �û�ID
	 * @param excludedStatus
	 *            ָ��״̬
	 * @return
	 */
	public List<Order> list(int uid, String excludedStatus) {
		return list(uid, excludedStatus, 0, Short.MAX_VALUE);
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
		String sql = "SELECT COUNT(1) FROM order_";
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
