package tmall.bean;

import java.util.Date;
import java.util.List;

/**
 * 订单
 * 
 * @author ZhanShiLun
 * @date 2017年9月6日 下午2:12:13
 *
 */
public class Order {
	/**
	 * 订单ID
	 */
	private int id;

	/**
	 * 用户ID
	 */
	private int uid;

	/**
	 * 订单号
	 */
	private String orderCode;

	/**
	 * 订单状态
	 */
	private String status;

	/**
	 * 收货地址
	 */
	private String address;

	/**
	 * 收货人信息
	 */
	private String receiver;

	/**
	 * 手机号码
	 */
	private String mobile;

	/**
	 * 邮编
	 */
	private String post;

	/**
	 * 用户备注信息
	 */
	private String userMessage;

	/**
	 * 支付日期
	 */
	private Date payDate;

	/**
	 * 发货日期
	 */
	private Date deliveryDate;

	/**
	 * 确认收货日期
	 */
	private Date confirmDate;

	/**
	 * 订单创建日期
	 */
	private Date createDate;

	/**
	 * 用户
	 */
	private User user;

	/**
	 * 订单项列表
	 */
	private List<OrderItem> orderItems;

	/**
	 * 订单总金额
	 */
	private float total;

	/**
	 * 订单总数量
	 */
	private int totalNumber;

	/**
	 * 获取订单ID
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:17:19
	 * @return 订单ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置订单ID
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:17:19
	 * @param id
	 *            订单ID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取用户ID
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:17:19
	 * @return 用户ID
	 */
	public int getUid() {
		return uid;
	}

	/**
	 * 设置用户ID
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:17:19
	 * @param uid
	 *            用户ID
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}

	/**
	 * 获取订单号
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:17:19
	 * @return 订单号
	 */
	public String getOrderCode() {
		return orderCode;
	}

	/**
	 * 设置订单号
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:17:19
	 * @param orderCode
	 *            订单号
	 */
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	/**
	 * 获取订单状态
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:17:19
	 * @return 订单状态
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 设置订单状态
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:17:19
	 * @param status
	 *            订单状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 获取收货地址
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:17:19
	 * @return 收货地址
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置收货地址
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:17:19
	 * @param address
	 *            收货地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 获取收货人信息
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:17:19
	 * @return 收货人信息
	 */
	public String getReceiver() {
		return receiver;
	}

	/**
	 * 设置收货人信息
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:17:19
	 * @param receiver
	 *            收货人信息
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	/**
	 * 获取手机号码
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:17:19
	 * @return 手机号码
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 设置手机号码
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:17:19
	 * @param mobile
	 *            手机号码
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 获取邮编
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:17:19
	 * @return 邮编
	 */
	public String getPost() {
		return post;
	}

	/**
	 * 设置邮编
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:17:19
	 * @param post
	 *            邮编
	 */
	public void setPost(String post) {
		this.post = post;
	}

	/**
	 * 获取用户备注信息
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:17:19
	 * @return 用户备注信息
	 */
	public String getUserMessage() {
		return userMessage;
	}

	/**
	 * 设置用户备注信息
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:17:19
	 * @param userMessage
	 *            用户备注信息
	 */
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	/**
	 * 获取支付日期
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:17:19
	 * @return 支付日期
	 */
	public Date getPayDate() {
		return payDate;
	}

	/**
	 * 设置支付日期
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:17:19
	 * @param payDate
	 *            支付日期
	 */
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	/**
	 * 获取发货日期
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:17:19
	 * @return 发货日期
	 */
	public Date getDeliveryDate() {
		return deliveryDate;
	}

	/**
	 * 设置发货日期
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:17:19
	 * @param deliveryDate
	 *            发货日期
	 */
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	/**
	 * 获取确认收货日期
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:17:19
	 * @return 确认收货日期
	 */
	public Date getConfirmDate() {
		return confirmDate;
	}

	/**
	 * 设置确认收货日期
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:17:19
	 * @param confirmDate
	 *            确认收货日期
	 */
	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}

	/**
	 * 获取订单创建日期
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:17:19
	 * @return 订单创建日期
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 设置订单创建日期
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:17:19
	 * @param createDate
	 *            订单创建日期
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 获取用户
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:21:47
	 * @return 用户
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 设置用户
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:21:47
	 * @param user
	 *            用户
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * 获取订单项列表
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:21:47
	 * @return 订单项列表
	 */
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	/**
	 * 设置订单项列表
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:21:47
	 * @param orderItems
	 *            订单项列表
	 */
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	/**
	 * 获取订单总金额
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:21:47
	 * @return 订单总金额
	 */
	public float getTotal() {
		return total;
	}

	/**
	 * 设置订单总金额
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:21:47
	 * @param total
	 *            订单总金额
	 */
	public void setTotal(float total) {
		this.total = total;
	}

	/**
	 * 获取订单总数量
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:21:47
	 * @return 订单总数量
	 */
	public int getTotalNumber() {
		return totalNumber;
	}

	/**
	 * 设置订单总数量
	 * 
	 * @author Administrator
	 * @date 2017年9月6日 下午2:21:47
	 * @param totalNumber
	 *            订单总数量
	 */
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
}
