package tmall.bean;

/**
 * ����
 * 
 * @author ZhanShiLun
 * @date 2017��9��5�� ����2:33:42
 *
 */
public class Property {
	/**
	 * ����ID
	 */
	private int id;

	/**
	 * ����ID
	 */
	private int cid;

	/**
	 * ��������
	 */
	private String name;

	/**
	 * ��ȡ����ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:31:17
	 * @return ����ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * ��������ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:31:28
	 * @param id
	 *            ����ID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * ��ȡ����ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:31:33
	 * @return ����ID
	 */
	public int getCid() {
		return cid;
	}

	/**
	 * ���÷���ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:31:40
	 * @param cid
	 *            ����ID
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}

	/**
	 * ��ȡ��������
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:31:48
	 * @return ��������
	 */
	public String getName() {
		return name;
	}

	/**
	 * ������������
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:31:59
	 * @param name
	 *            ��������
	 */
	public void setName(String name) {
		this.name = name;
	}
}
