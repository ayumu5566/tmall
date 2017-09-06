package tmall.bean;

import java.util.Date;

/**
 * 评价
 * 
 * @author ZhanShiLun
 * @date 2017年9月6日 下午2:04:11
 *
 */
public class Review {
	/**
	 * 评价ID
	 */
	private int id;
	/**
	 * 内容
	 */
	private String content;

	/**
	 * 用户ID
	 */
	private int uid;

	/**
	 * 产品ID
	 */
	private int pid;

	/**
	 * 创建时间
	 */
	private Date createDate;

	/**
	 * 用户
	 */
	private User user;

	/**
	 * 产品
	 */
	private Product product;

	/**
	 * 获取评价ID
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:09:06
	 * @return 评价ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置评价ID
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:09:07
	 * @param id
	 *            评价ID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取内容
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:09:07
	 * @return 内容
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置内容
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:09:07
	 * @param content
	 *            内容
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 获取用户ID
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:09:07
	 * @return 用户ID
	 */
	public int getUid() {
		return uid;
	}

	/**
	 * 设置用户ID
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:09:07
	 * @param uid
	 *            用户ID
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}

	/**
	 * 获取产品ID
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:09:07
	 * @return 产品ID
	 */
	public int getPid() {
		return pid;
	}

	/**
	 * 设置产品ID
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:09:07
	 * @param pid
	 *            产品ID
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}

	/**
	 * 获取创建时间
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:09:07
	 * @return 创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 设置创建时间
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:09:07
	 * @param createDate
	 *            创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 获取用户
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:11:34
	 * @return 用户
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 设置用户
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:11:34
	 * @param user
	 *            用户
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 获取产品
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:11:34
	 * @return 产品
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * 设置产品
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:11:34
	 * @param product
	 *            产品
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
}
