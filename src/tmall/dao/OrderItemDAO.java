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
 * ������DAO
 * 
 * @author ZhanShiLun
 * @date 2017��9��7�� ����11:18:01
 *
 */
public class OrderItemDAO {

	/**
	 * ����
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:57:00
	 * @param bean
	 *            ������
	 */
	public void add(OrderItem bean) {
		String sql = "INSERT INTO orderitem VALUES (null, ?, ?, ?, ?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			// ���ò���
			ps.setInt(1, bean.getProduct().getId());

			if (null == bean.getOrder()) {
				ps.setInt(2, -1);
			} else {
				ps.setInt(2, bean.getOrder().getId());
			}
			ps.setInt(3, bean.getUid());
			ps.setInt(4, bean.getNumber());

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
	 *            ������ID
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
	 * �޸�
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:57:14
	 * @param bean
	 *            ������
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
	 * ����id��ȡ
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:57:21
	 * @param id
	 *            ������ID
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
	 * ��ѯĳ���û���δ���ɶ����Ķ�����(�ȹ��ﳵ�еĶ�����)����ҳ��
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:57:26
	 * @param uid
	 *            �û�ID
	 * @param start
	 *            ��ʼ����
	 * @param count
	 *            ��ʾ����
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
	 * ��ѯĳ���û���δ���ɶ����Ķ�����(�ȹ��ﳵ�еĶ�����)������ҳ��
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��7�� ����11:12:32
	 * @param uid
	 *            �û�ID
	 * @return
	 */
	public List<OrderItem> listByUser(int uid) {
		return listByUser(uid, 0, Short.MAX_VALUE);
	}

	/**
	 * ��ѯĳ�ֶ��������еĶ������ҳ��
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:57:26
	 * @param oid
	 *            ����ID
	 * @param start
	 *            ��ʼ����
	 * @param count
	 *            ��ʾ����
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
	 * ��ѯĳ�ֶ��������еĶ��������ҳ��
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��7�� ����11:12:07
	 * @param oid
	 *            ����ID
	 * @return
	 */
	public List<OrderItem> listByOrder(int oid) {
		return listByOrder(oid, 0, Short.MAX_VALUE);
	}

	/**
	 * ��ѯĳ�ֲ�Ʒ�����еĶ������ҳ��
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
	 * ��ѯĳ�ֲ�Ʒ�����еĶ��������ҳ��
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��7�� ����11:11:54
	 * @param pid
	 *            ��ƷID
	 * @return
	 */
	public List<OrderItem> listByProduct(int pid) {
		return listByUser(pid, 0, Short.MAX_VALUE);
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
	 * Ϊ�������ö������
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��7�� ����11:13:24
	 * @param os
	 *            ��������
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
	 * Ϊ�������ö������
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��7�� ����11:14:38
	 * @param o
	 *            ����
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
	 * ��ȡĳһ�ֲ�Ʒ�������� ��Ʒ�����������ֲ�Ʒ��Ӧ�Ķ�����OrderItem��number�ֶε��ܺ�
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��7�� ����11:17:33
	 * @param pid
	 *            ��ƷID
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
