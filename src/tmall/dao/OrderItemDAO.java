package tmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tmall.bean.Order;
import tmall.bean.OrderItem;
import tmall.util.DBUtil;

/**
 * 订单项DAO
 * 
 * @author ZhanShiLun
 * @date 2017年9月7日 上午11:18:01
 *
 */
public class OrderItemDAO {

	/**
	 * 增加
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:57:00
	 * @param bean
	 *            订单项
	 */
	public void add(OrderItem bean) {
		String sql = "INSERT INTO orderitem VALUES (null, ?, ?, ?, ?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			// 设置参数
			ps.setInt(1, bean.getProduct().getId());

			if (null == bean.getOrder()) {
				ps.setInt(2, -1);
			} else {
				ps.setInt(2, bean.getOrder().getId());
			}
			ps.setInt(3, bean.getUid());
			ps.setInt(4, bean.getNumber());

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
	 *            订单项ID
	 */
	public void delete(int id) {
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
			String sql = "DELETE FROM orderitem oi WHERE oi.id = " + id;
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
	 *            订单项
	 */
	public void update(OrderItem bean) {
		String sql = "UPDATE orderitem oi SET oi.pid = ?, oi.oid = ?, oi.uid = ?, oi.number = ? WHERE oi.id = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, bean.getProduct().getId());
			if (null == bean.getOrder()) {
				ps.setInt(2, -1);
			} else {
				ps.setInt(2, bean.getOrder().getId());
			}
			ps.setInt(3, bean.getUser().getId());
			ps.setInt(4, bean.getNumber());
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
	 *            订单项ID
	 */
	public OrderItem get(int id) {
		OrderItem orderItem = null;
		String sql = "SELECT oi.id, oi.pid, oi.oid, oi.uid, oi.number FROM orderitem oi WHERE oi.id = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, id);
			ps.execute();
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				orderItem = new OrderItem();
				orderItem.setId(rs.getInt(1));
				orderItem.setPid(rs.getInt(2));
				orderItem.setOid(rs.getInt(3));
				orderItem.setUid(rs.getInt(4));
				orderItem.setNumber(rs.getInt(5));
				orderItem.setProduct(new ProductDAO().get(rs.getInt(2)));
				if (rs.getInt(4) != -1) {
					orderItem.setOrder(new OrderDAO().get(rs.getInt(3)));
				}
				orderItem.setUser(new UserDAO().get(rs.getInt(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderItem;
	}

	/**
	 * 查询某个用户的未生成订单的订单项(既购物车中的订单项)（分页）
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:57:26
	 * @param uid
	 *            用户ID
	 * @param start
	 *            开始条数
	 * @param count
	 *            显示数量
	 * @return
	 */
	public List<OrderItem> listByUser(int uid, int start, int count) {
		List<OrderItem> beans = new ArrayList<OrderItem>();

		String sql = "SELECT oi.id, oi.pid, oi.oid, oi.uid, oi.number FROM orderitem oi WHERE oi.uid = ? and oid = -1 ORDER BY oi.id DESC LIMIT ?, ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, uid);
			ps.setInt(2, start);
			ps.setInt(3, count);

			ps.execute();

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderItem orderItem = new OrderItem();
				orderItem.setId(rs.getInt(1));
				orderItem.setPid(rs.getInt(2));
				orderItem.setOid(rs.getInt(3));
				orderItem.setUid(rs.getInt(4));
				orderItem.setNumber(rs.getInt(5));
				orderItem.setProduct(new ProductDAO().get(rs.getInt(2)));
				if (rs.getInt(4) != -1) {
					orderItem.setOrder(new OrderDAO().get(rs.getInt(3)));
				}
				orderItem.setUser(new UserDAO().get(rs.getInt(4)));
				beans.add(orderItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return beans;
	}

	/**
	 * 查询某个用户的未生成订单的订单项(既购物车中的订单项)（不分页）
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月7日 上午11:12:32
	 * @param uid
	 *            用户ID
	 * @return
	 */
	public List<OrderItem> listByUser(int uid) {
		return listByUser(uid, 0, Short.MAX_VALUE);
	}

	/**
	 * 查询某种订单下所有的订单项（分页）
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:57:26
	 * @param oid
	 *            订单ID
	 * @param start
	 *            开始条数
	 * @param count
	 *            显示数量
	 * @return
	 */
	public List<OrderItem> listByOrder(int oid, int start, int count) {
		List<OrderItem> beans = new ArrayList<OrderItem>();

		String sql = "SELECT oi.id, oi.pid, oi.oid, oi.uid, oi.number FROM orderitem oi WHERE oi.oid = ? ORDER BY oi.id DESC LIMIT ?, ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, oid);
			ps.setInt(2, start);
			ps.setInt(3, count);

			ps.execute();

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderItem orderItem = new OrderItem();
				orderItem.setId(rs.getInt(1));
				orderItem.setPid(rs.getInt(2));
				orderItem.setOid(rs.getInt(3));
				orderItem.setUid(rs.getInt(4));
				orderItem.setNumber(rs.getInt(5));
				orderItem.setProduct(new ProductDAO().get(rs.getInt(2)));
				if (rs.getInt(4) != -1) {
					orderItem.setOrder(new OrderDAO().get(rs.getInt(3)));
				}
				orderItem.setUser(new UserDAO().get(rs.getInt(4)));
				beans.add(orderItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return beans;
	}

	/**
	 * 查询某种订单下所有的订单项（不分页）
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月7日 上午11:12:07
	 * @param oid
	 *            订单ID
	 * @return
	 */
	public List<OrderItem> listByOrder(int oid) {
		return listByOrder(oid, 0, Short.MAX_VALUE);
	}

	/**
	 * 查询某种产品下所有的订单项（分页）
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
	public List<OrderItem> listByProduct(int pid, int start, int count) {
		List<OrderItem> beans = new ArrayList<OrderItem>();

		String sql = "SELECT oi.id, oi.pid, oi.oid, oi.uid, oi.number FROM orderitem oi WHERE oi.pid = ? ORDER BY oi.id DESC LIMIT ?, ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, pid);
			ps.setInt(2, start);
			ps.setInt(3, count);

			ps.execute();

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderItem orderItem = new OrderItem();
				orderItem.setId(rs.getInt(1));
				orderItem.setPid(rs.getInt(2));
				orderItem.setOid(rs.getInt(3));
				orderItem.setUid(rs.getInt(4));
				orderItem.setNumber(rs.getInt(5));
				orderItem.setProduct(new ProductDAO().get(rs.getInt(2)));
				if (rs.getInt(4) != -1) {
					orderItem.setOrder(new OrderDAO().get(rs.getInt(3)));
				}
				orderItem.setUser(new UserDAO().get(rs.getInt(4)));
				beans.add(orderItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return beans;
	}

	/**
	 * 查询某种产品下所有的订单项（不分页）
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月7日 上午11:11:54
	 * @param pid
	 *            产品ID
	 * @return
	 */
	public List<OrderItem> listByProduct(int pid) {
		return listByUser(pid, 0, Short.MAX_VALUE);
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
		String sql = "SELECT COUNT(1) FROM orderitem";
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
	 * 为订单设置订单项集合
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月7日 上午11:13:24
	 * @param os
	 *            订单集合
	 */
	public void fill(List<Order> os) {
		for (Order o : os) {
			List<OrderItem> ois = listByOrder(o.getId());
			float total = 0;
			int totalNumber = 0;
			for (OrderItem oi : ois) {
				total += oi.getNumber() * oi.getProduct().getPromotePrice();
				totalNumber += oi.getNumber();
			}
			o.setTotal(total);
			o.setOrderItems(ois);
			o.setTotalNumber(totalNumber);
		}
	}

	/**
	 * 为订单设置订单项集合
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月7日 上午11:14:38
	 * @param o
	 *            订单
	 */
	public void fill(Order o) {
		List<OrderItem> ois = listByOrder(o.getId());
		float total = 0;
		for (OrderItem oi : ois) {
			total += oi.getNumber() * oi.getProduct().getPromotePrice();
		}
		o.setTotal(total);
		o.setOrderItems(ois);
	}

	/**
	 * 获取某一种产品的销量。 产品销量就是这种产品对应的订单项OrderItem的number字段的总和
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月7日 上午11:17:33
	 * @param pid
	 *            产品ID
	 * @return
	 */
	public int getSaleCount(int pid) {
		int total = 0;
		String sql = "SELECT SUM(oi.number) FROM orderitem oi WHERE oi.pid = ?";
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
}
