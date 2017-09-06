package tmall.bean;

/**
 * 属性
 * 
 * @author ZhanShiLun
 * @date 2017年9月5日 下午2:33:42
 *
 */
public class Property {
	/**
	 * 属性ID
	 */
	private int id;

	/**
	 * 分类ID
	 */
	private int cid;

	/**
	 * 属性名称
	 */
	private String name;

	/**
	 * 获取属性ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:31:17
	 * @return 属性ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置属性ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:31:28
	 * @param id
	 *            属性ID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取分类ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:31:33
	 * @return 分类ID
	 */
	public int getCid() {
		return cid;
	}

	/**
	 * 设置分类ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:31:40
	 * @param cid
	 *            分类ID
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}

	/**
	 * 获取属性名称
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:31:48
	 * @return 属性名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置属性名称
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:31:59
	 * @param name
	 *            属性名称
	 */
	public void setName(String name) {
		this.name = name;
	}
}
