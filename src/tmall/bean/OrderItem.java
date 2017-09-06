package tmall.bean;

/**
 * 订单项
 * 
 * @author ZhanShiLun
 * @date 2017年9月6日 下午2:24:35
 *
 */
public class OrderItem {
	/**
	 * 订单项ID
	 */
	private int id;

	/**
	 * 产品ID
	 */
	private int pid;

	/**
	 * 订单ID
	 */
	private int oid;

	/**
	 * 用户ID
	 */
	private int uid;

	/**
	 * 购买数量
	 */
	private int number;

	/**
	 * 产品
	 */
	private Product product;

	/**
	 * 订单
	 */
	private Order order;

	/**
	 * 用户
	 */
	private User user;

	/**
	 * 获取订单项ID
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:24:18
	 * @return 订单项ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置订单项ID
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:24:18
	 * @param id
	 *            订单项ID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取产品ID
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:24:18
	 * @return 产品ID
	 */
	public int getPid() {
		return pid;
	}

	/**
	 * 设置产品ID
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:24:18
	 * @param pid
	 *            产品ID
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}

	/**
	 * 获取订单ID
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:24:18
	 * @return 订单ID
	 */
	public int getOid() {
		return oid;
	}

	/**
	 * 设置订单ID
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:24:18
	 * @param oid
	 *            订单ID
	 */
	public void setOid(int oid) {
		this.oid = oid;
	}

	/**
	 * 获取用户ID
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:24:18
	 * @return 用户ID
	 */
	public int getUid() {
		return uid;
	}

	/**
	 * 设置用户ID
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:24:18
	 * @param uid
	 *            用户ID
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}

	/**
	 * 获取购买数量
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:24:18
	 * @return 购买数量
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * 设置购买数量
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:24:18
	 * @param number
	 *            购买数量
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * 获取产品
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:27:00
	 * @return 产品
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * 设置产品
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:27:00
	 * @param product
	 *            产品
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * 获取订单
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:27:00
	 * @return 订单
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * 设置订单
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:27:00
	 * @param order
	 *            订单
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * 获取用户
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:27:00
	 * @return 用户
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 设置用户
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:27:00
	 * @param user
	 *            用户
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
