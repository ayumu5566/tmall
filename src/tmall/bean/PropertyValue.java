package tmall.bean;

/**
 * 属性值
 * 
 * @author ZhanShiLun
 * @date 2017年9月6日 下午2:00:58
 *
 */
public class PropertyValue {
	/**
	 * 属性值ID
	 */
	private int id;

	/**
	 * 产品ID
	 */
	private int pid;

	/**
	 * 属性ID
	 */
	private int ptid;

	/**
	 * 属性值
	 */
	private String value;

	/**
	 * 产品
	 */
	private Product product;

	/**
	 * 属性
	 */
	private Property property;

	/**
	 * 获取属性值ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:01:54
	 * @return 属性值ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置属性值ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:02:08
	 * @param id
	 *            属性值ID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取产品ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:02:15
	 * @return 产品ID
	 */
	public int getPid() {
		return pid;
	}

	/**
	 * 设置产品ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:02:26
	 * @param pid
	 *            产品ID
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}

	/**
	 * 获取属性ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:02:32
	 * @return 属性ID
	 */
	public int getPtid() {
		return ptid;
	}

	/**
	 * 设置属性ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:02:44
	 * @param ptid
	 *            属性ID
	 */
	public void setPtid(int ptid) {
		this.ptid = ptid;
	}

	/**
	 * 获取属性值
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:02:51
	 * @return 属性值
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 设置属性值
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:03:02
	 * @param value
	 *            属性值
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 获取产品
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:03:10
	 * @return 产品
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * 设置产品
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:03:18
	 * @param product
	 *            产品
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * 获取属性
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:03:26
	 * @return 属性
	 */
	public Property getProperty() {
		return property;
	}

	/**
	 * 设置属性
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午2:03:38
	 * @param property
	 *            属性
	 */
	public void setProperty(Property property) {
		this.property = property;
	}
}
