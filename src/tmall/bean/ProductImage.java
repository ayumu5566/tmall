package tmall.bean;

/**
 * 产品图片
 * 
 * @author ZhanShiLun
 * @date 2017年9月6日 下午1:59:27
 *
 */
public class ProductImage {
	/**
	 * 产品图片ID
	 */
	private int id;

	/**
	 * 产品ID
	 */
	private int pid;

	/**
	 * 图片类型（单个/详情）
	 */
	private String type;

	/**
	 * 产品
	 */
	private Product product;

	/**
	 * 获取产品图片ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午1:53:03
	 * @return 产品图片ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置产品图片ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午1:53:12
	 * @param id
	 *            产品图片ID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取产品ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午1:53:19
	 * @return 产品ID
	 */
	public int getPid() {
		return pid;
	}

	/**
	 * 设置产品ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午1:53:32
	 * @param pid
	 *            产品ID
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}

	/**
	 * 获取图片类型（单个/详情）
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午1:53:38
	 * @return 图片类型（单个/详情）
	 */
	public String getType() {
		return type;
	}

	/**
	 * 设置图片类型（单个/详情）
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午1:53:47
	 * @param type
	 *            图片类型（单个/详情）
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 获取产品
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午1:53:52
	 * @return 产品
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * 设置产品
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午1:54:02
	 * @param product
	 *            产品
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
}
