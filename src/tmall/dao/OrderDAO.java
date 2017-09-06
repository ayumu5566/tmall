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
	 * 待付款
	 */
	public static final String waitPay = "waitPay";

	/**
	 * 待发货
	 */
	public static final String waitDelivery = "waitDelivery";

	/**
	 * 待确认
	 */
	public static final String waitConfirm = "waitConfirm";

	/**
	 * 待评价
	 */
	public static final String waitReview = "waitReview";

	/**
	 * 已完成
	 */
	public static final String finish = "finish";

	/**
	 * 已删除
	 */
	public static final String delete = "delete";

	/**
	 * 增加
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:57:00
	 * @param bean
	 *            订单
	 */
	public void add(Order bean) {
		String sql = "INSERT INTO order_ VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			// 设置参数
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
	 *            订单ID
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
	 * 修改
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:57:14
	 * @param bean
	 *            订单
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
	 * 根据id获取
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:57:21
	 * @param id
	 *            订单ID
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
	 * 查询所有订单信息（分页）
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:57:26
	 * @param start
	 *            开始条数
	 * @param count
	 *            显示数量
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
	 * 查询所有订单信息（不分页）
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月7日 上午10:12:18
	 * @return
	 */
	public List<Order> list() {
		return list(0, Short.MAX_VALUE);
	}

	/**
	 * 查询指定用户的订单（分页）
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月7日 上午10:13:12
	 * @param uid
	 *            用户ID
	 * @param excludedStatus
	 *            指定状态
	 * @param start
	 *            开始条数
	 * @param count
	 *            显示数量
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
	 * 查询指定用户的订单（不分页）
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月7日 上午10:13:54
	 * @param uid
	 *            用户ID
	 * @param excludedStatus
	 *            指定状态
	 * @return
	 */
	public List<Order> list(int uid, String excludedStatus) {
		return list(uid, excludedStatus, 0, Short.MAX_VALUE);
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
