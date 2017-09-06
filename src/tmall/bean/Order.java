package tmall.bean;

import java.util.Date;
import java.util.List;

/**
 * ����
 * 
 * @author ZhanShiLun
 * @date 2017��9��6�� ����2:12:13
 *
 */
public class Order {
	/**
	 * ����ID
	 */
	private int id;

	/**
	 * �û�ID
	 */
	private int uid;

	/**
	 * ������
	 */
	private String orderCode;

	/**
	 * ����״̬
	 */
	private String status;

	/**
	 * �ջ���ַ
	 */
	private String address;

	/**
	 * �ջ�����Ϣ
	 */
	private String receiver;

	/**
	 * �ֻ�����
	 */
	private String mobile;

	/**
	 * �ʱ�
	 */
	private String post;

	/**
	 * �û���ע��Ϣ
	 */
	private String userMessage;

	/**
	 * ֧������
	 */
	private Date payDate;

	/**
	 * ��������
	 */
	private Date deliveryDate;

	/**
	 * ȷ���ջ�����
	 */
	private Date confirmDate;

	/**
	 * ������������
	 */
	private Date createDate;

	/**
	 * �û�
	 */
	private User user;

	/**
	 * �������б�
	 */
	private List<OrderItem> orderItems;

	/**
	 * �����ܽ��
	 */
	private float total;

	/**
	 * ����������
	 */
	private int totalNumber;

	/**
	 * ��ȡ����ID
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:17:19
	 * @return ����ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * ���ö���ID
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:17:19
	 * @param id
	 *            ����ID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * ��ȡ�û�ID
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:17:19
	 * @return �û�ID
	 */
	public int getUid() {
		return uid;
	}

	/**
	 * �����û�ID
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:17:19
	 * @param uid
	 *            �û�ID
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}

	/**
	 * ��ȡ������
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:17:19
	 * @return ������
	 */
	public String getOrderCode() {
		return orderCode;
	}

	/**
	 * ���ö�����
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:17:19
	 * @param orderCode
	 *            ������
	 */
	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	/**
	 * ��ȡ����״̬
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:17:19
	 * @return ����״̬
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * ���ö���״̬
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:17:19
	 * @param status
	 *            ����״̬
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * ��ȡ�ջ���ַ
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:17:19
	 * @return �ջ���ַ
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * �����ջ���ַ
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:17:19
	 * @param address
	 *            �ջ���ַ
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * ��ȡ�ջ�����Ϣ
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:17:19
	 * @return �ջ�����Ϣ
	 */
	public String getReceiver() {
		return receiver;
	}

	/**
	 * �����ջ�����Ϣ
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:17:19
	 * @param receiver
	 *            �ջ�����Ϣ
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	/**
	 * ��ȡ�ֻ�����
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:17:19
	 * @return �ֻ�����
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * �����ֻ�����
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:17:19
	 * @param mobile
	 *            �ֻ�����
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * ��ȡ�ʱ�
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:17:19
	 * @return �ʱ�
	 */
	public String getPost() {
		return post;
	}

	/**
	 * �����ʱ�
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:17:19
	 * @param post
	 *            �ʱ�
	 */
	public void setPost(String post) {
		this.post = post;
	}

	/**
	 * ��ȡ�û���ע��Ϣ
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:17:19
	 * @return �û���ע��Ϣ
	 */
	public String getUserMessage() {
		return userMessage;
	}

	/**
	 * �����û���ע��Ϣ
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:17:19
	 * @param userMessage
	 *            �û���ע��Ϣ
	 */
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	/**
	 * ��ȡ֧������
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:17:19
	 * @return ֧������
	 */
	public Date getPayDate() {
		return payDate;
	}

	/**
	 * ����֧������
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:17:19
	 * @param payDate
	 *            ֧������
	 */
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

	/**
	 * ��ȡ��������
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:17:19
	 * @return ��������
	 */
	public Date getDeliveryDate() {
		return deliveryDate;
	}

	/**
	 * ���÷�������
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:17:19
	 * @param deliveryDate
	 *            ��������
	 */
	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	/**
	 * ��ȡȷ���ջ�����
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:17:19
	 * @return ȷ���ջ�����
	 */
	public Date getConfirmDate() {
		return confirmDate;
	}

	/**
	 * ����ȷ���ջ�����
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:17:19
	 * @param confirmDate
	 *            ȷ���ջ�����
	 */
	public void setConfirmDate(Date confirmDate) {
		this.confirmDate = confirmDate;
	}

	/**
	 * ��ȡ������������
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:17:19
	 * @return ������������
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * ���ö�����������
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:17:19
	 * @param createDate
	 *            ������������
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * ��ȡ�û�
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:21:47
	 * @return �û�
	 */
	public User getUser() {
		return user;
	}

	/**
	 * �����û�
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:21:47
	 * @param user
	 *            �û�
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * ��ȡ�������б�
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:21:47
	 * @return �������б�
	 */
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	/**
	 * ���ö������б�
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:21:47
	 * @param orderItems
	 *            �������б�
	 */
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	/**
	 * ��ȡ�����ܽ��
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:21:47
	 * @return �����ܽ��
	 */
	public float getTotal() {
		return total;
	}

	/**
	 * ���ö����ܽ��
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:21:47
	 * @param total
	 *            �����ܽ��
	 */
	public void setTotal(float total) {
		this.total = total;
	}

	/**
	 * ��ȡ����������
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:21:47
	 * @return ����������
	 */
	public int getTotalNumber() {
		return totalNumber;
	}

	/**
	 * ���ö���������
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:21:47
	 * @param totalNumber
	 *            ����������
	 */
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
}
