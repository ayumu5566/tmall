package tmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import tmall.bean.Product;
import tmall.bean.Property;
import tmall.bean.PropertyValue;
import tmall.util.DBUtil;

/**
 * 属性值DAO
 * 
 * @author ZhanShiLun
 * @date 2017年9月6日 下午4:48:36
 *
 */
public class PropertyValueDAO {

	/**
	 * 增加
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:57:00
	 * @param bean
	 *            属性值
	 */
	public void add(PropertyValue bean) {
		String sql = "INSERT INTO propertyvalue VALUES (null, ?, ?, ?)";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			// 设置参数
			ps.setInt(1, bean.getPid());
			ps.setInt(2, bean.getPtid());
			ps.setString(3, bean.getValue());

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
	 *            属性值ID
	 */
	public void delete(int id) {
		try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {
			String sql = "DELETE FROM propertyvalue pv WHERE pv.id = " + id;
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
	 *            属性值
	 */
	public void update(PropertyValue bean) {
		String sql = "UPDATE propertyvalue pv SET pv.pid = ?, pv.ptid = ?, pv.value = ? WHERE pv.id = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, bean.getPid());
			ps.setInt(2, bean.getPtid());
			ps.setString(3, bean.getValue());
			ps.setInt(4, bean.getId());
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
	 *            属性值ID
	 */
	public PropertyValue get(int id) {
		PropertyValue propertyValue = null;
		String sql = "SELECT pv.id, pv.pid, pv.ptid, pv.value FROM propertyvalue pv WHERE pv.id = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, id);
			ps.execute();
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				propertyValue = new PropertyValue();
				propertyValue.setId(rs.getInt(1));
				propertyValue.setPid(rs.getInt(2));
				propertyValue.setPtid(rs.getInt(3));
				propertyValue.setValue(rs.getString(4));
				propertyValue.setProduct(new ProductDAO().get(rs.getInt(2)));
				propertyValue.setProperty(new PropertyDAO().get(rs.getInt(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return propertyValue;
	}

	/**
	 * 根据产品ID，属性ID获取
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午5:02:25
	 * @param ptid
	 * @param pid
	 * @return
	 */
	public PropertyValue get(int pid, int ptid) {
		PropertyValue propertyValue = null;
		String sql = "SELECT pv.id, pv.pid, pv.ptid, pv.value FROM propertyvalue pv WHERE pv.pid = ? AND pv.ptid = ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
			ps.setInt(1, pid);
			ps.setInt(2, ptid);
			ps.execute();
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				propertyValue = new PropertyValue();
				propertyValue.setId(rs.getInt(1));
				propertyValue.setPid(rs.getInt(2));
				propertyValue.setPtid(rs.getInt(3));
				propertyValue.setValue(rs.getString(4));
				propertyValue.setProduct(new ProductDAO().get(pid));
				propertyValue.setProperty(new PropertyDAO().get(ptid));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return propertyValue;
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
	public List<PropertyValue> list(int start, int count) {
		List<PropertyValue> beans = new ArrayList<PropertyValue>();

		String sql = "SELECT pv.id, pv.pid, pv.ptid, pv.value FROM propertyvalue pv ORDER BY pv.id LIMIT ?, ?";
		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, start);
			ps.setInt(2, count);

			ps.execute();

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PropertyValue propertyValue = new PropertyValue();
				propertyValue.setId(rs.getInt(1));
				propertyValue.setPid(rs.getInt(2));
				propertyValue.setPtid(rs.getInt(3));
				propertyValue.setValue(rs.getString(4));
				propertyValue.setProduct(new ProductDAO().get(rs.getInt(2)));
				propertyValue.setProperty(new PropertyDAO().get(rs.getInt(3)));
				beans.add(propertyValue);
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
	public List<PropertyValue> list() {
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
		String sql = "SELECT COUNT(1) FROM propertyvalue";
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
	 * 初始化某个产品对应的属性值，初始化逻辑： 1.根据分类获取所有的属性 2.遍历每一个属性 2.1 根据属性和产品，获取属性值 2.2
	 * 如果属性值不存在，就创建一个属性值对象
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午5:09:22
	 * @param product
	 *            产品
	 */
	public void init(Product product) {
		List<Property> pts = new PropertyDAO().list(product.getCategory().getId());

		for (Property pt : pts) {
			PropertyValue pv = get(pt.getId(), product.getId());
			if (null == pv) {
				pv = new PropertyValue();
				pv.setProduct(product);
				pv.setProperty(pt);
				this.add(pv);
			}
		}
	}

	/**
	 * 查询某个产品下所有的属性值
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午5:10:58
	 * @param pid
	 *            产品ID
	 * @return
	 */
	public List<PropertyValue> list(int pid) {
		List<PropertyValue> beans = new ArrayList<PropertyValue>();

		String sql = "SELECT pv.id, pv.pid, pv.ptid, pv.value FROM propertyvalue pv WHERE pv.pid = ? ORDER BY pv.ptid DESC";

		try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

			ps.setInt(1, pid);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				PropertyValue propertyValue = new PropertyValue();
				propertyValue.setId(rs.getInt(1));
				propertyValue.setPtid(rs.getInt(3));
				propertyValue.setValue(rs.getString(4));
				propertyValue.setProduct(new ProductDAO().get(pid));
				propertyValue.setProperty(new PropertyDAO().get(rs.getInt(3)));
				beans.add(propertyValue);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return beans;
	}
}
