package tmall.bean;

/**
 * ����ֵ
 * 
 * @author ZhanShiLun
 * @date 2017��9��6�� ����2:00:58
 *
 */
public class PropertyValue {
	/**
	 * ����ֵID
	 */
	private int id;

	/**
	 * ��ƷID
	 */
	private int pid;

	/**
	 * ����ID
	 */
	private int ptid;

	/**
	 * ����ֵ
	 */
	private String value;

	/**
	 * ��Ʒ
	 */
	private Product product;

	/**
	 * ����
	 */
	private Property property;

	/**
	 * ��ȡ����ֵID
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:01:54
	 * @return ����ֵID
	 */
	public int getId() {
		return id;
	}

	/**
	 * ��������ֵID
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:02:08
	 * @param id
	 *            ����ֵID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * ��ȡ��ƷID
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:02:15
	 * @return ��ƷID
	 */
	public int getPid() {
		return pid;
	}

	/**
	 * ���ò�ƷID
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:02:26
	 * @param pid
	 *            ��ƷID
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}

	/**
	 * ��ȡ����ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:02:32
	 * @return ����ID
	 */
	public int getPtid() {
		return ptid;
	}

	/**
	 * ��������ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:02:44
	 * @param ptid
	 *            ����ID
	 */
	public void setPtid(int ptid) {
		this.ptid = ptid;
	}

	/**
	 * ��ȡ����ֵ
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:02:51
	 * @return ����ֵ
	 */
	public String getValue() {
		return value;
	}

	/**
	 * ��������ֵ
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:03:02
	 * @param value
	 *            ����ֵ
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * ��ȡ��Ʒ
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:03:10
	 * @return ��Ʒ
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * ���ò�Ʒ
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:03:18
	 * @param product
	 *            ��Ʒ
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * ��ȡ����
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:03:26
	 * @return ����
	 */
	public Property getProperty() {
		return property;
	}

	/**
	 * ��������
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����2:03:38
	 * @param property
	 *            ����
	 */
	public void setProperty(Property property) {
		this.property = property;
	}
}
