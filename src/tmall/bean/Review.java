package tmall.bean;

import java.util.Date;

/**
 * ����
 * 
 * @author ZhanShiLun
 * @date 2017��9��6�� ����2:04:11
 *
 */
public class Review {
	/**
	 * ����ID
	 */
	private int id;
	/**
	 * ����
	 */
	private String content;

	/**
	 * �û�ID
	 */
	private int uid;

	/**
	 * ��ƷID
	 */
	private int pid;

	/**
	 * ����ʱ��
	 */
	private Date createDate;

	/**
	 * �û�
	 */
	private User user;

	/**
	 * ��Ʒ
	 */
	private Product product;

	/**
	 * ��ȡ����ID
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:09:06
	 * @return ����ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * ��������ID
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:09:07
	 * @param id
	 *            ����ID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * ��ȡ����
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:09:07
	 * @return ����
	 */
	public String getContent() {
		return content;
	}

	/**
	 * ��������
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:09:07
	 * @param content
	 *            ����
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * ��ȡ�û�ID
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:09:07
	 * @return �û�ID
	 */
	public int getUid() {
		return uid;
	}

	/**
	 * �����û�ID
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:09:07
	 * @param uid
	 *            �û�ID
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}

	/**
	 * ��ȡ��ƷID
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:09:07
	 * @return ��ƷID
	 */
	public int getPid() {
		return pid;
	}

	/**
	 * ���ò�ƷID
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:09:07
	 * @param pid
	 *            ��ƷID
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}

	/**
	 * ��ȡ����ʱ��
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:09:07
	 * @return ����ʱ��
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * ���ô���ʱ��
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:09:07
	 * @param createDate
	 *            ����ʱ��
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * ��ȡ�û�
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:11:34
	 * @return �û�
	 */
	public User getUser() {
		return user;
	}

	/**
	 * �����û�
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:11:34
	 * @param user
	 *            �û�
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * ��ȡ��Ʒ
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:11:34
	 * @return ��Ʒ
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * ���ò�Ʒ
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:11:34
	 * @param product
	 *            ��Ʒ
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
}
