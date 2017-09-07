package tmall.bean;

/**
 * ������
 * 
 * @author ZhanShiLun
 * @date 2017��9��6�� ����2:24:35
 *
 */
public class OrderItem {
	/**
	 * ������ID
	 */
	private int id;

	/**
	 * ��ƷID
	 */
	private int pid;

	/**
	 * ����ID
	 */
	private int oid;

	/**
	 * �û�ID
	 */
	private int uid;

	/**
	 * ��������
	 */
	private int number;

	/**
	 * ��Ʒ
	 */
	private Product product;

	/**
	 * ����
	 */
	private Order order;

	/**
	 * �û�
	 */
	private User user;

	/**
	 * ��ȡ������ID
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:24:18
	 * @return ������ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * ���ö�����ID
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:24:18
	 * @param id
	 *            ������ID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * ��ȡ��ƷID
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:24:18
	 * @return ��ƷID
	 */
	public int getPid() {
		return pid;
	}

	/**
	 * ���ò�ƷID
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:24:18
	 * @param pid
	 *            ��ƷID
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}

	/**
	 * ��ȡ����ID
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:24:18
	 * @return ����ID
	 */
	public int getOid() {
		return oid;
	}

	/**
	 * ���ö���ID
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:24:18
	 * @param oid
	 *            ����ID
	 */
	public void setOid(int oid) {
		this.oid = oid;
	}

	/**
	 * ��ȡ�û�ID
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:24:18
	 * @return �û�ID
	 */
	public int getUid() {
		return uid;
	}

	/**
	 * �����û�ID
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:24:18
	 * @param uid
	 *            �û�ID
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}

	/**
	 * ��ȡ��������
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:24:18
	 * @return ��������
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * ���ù�������
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:24:18
	 * @param number
	 *            ��������
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * ��ȡ��Ʒ
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:27:00
	 * @return ��Ʒ
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * ���ò�Ʒ
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:27:00
	 * @param product
	 *            ��Ʒ
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * ��ȡ����
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:27:00
	 * @return ����
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * ���ö���
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:27:00
	 * @param order
	 *            ����
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * ��ȡ�û�
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:27:00
	 * @return �û�
	 */
	public User getUser() {
		return user;
	}

	/**
	 * �����û�
	 * 
	 * @author Administrator
	 * @date 2017��9��6�� ����2:27:00
	 * @param user
	 *            �û�
	 */
	public void setUser(User user) {
		this.user = user;
	}

}
