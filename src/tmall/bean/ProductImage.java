package tmall.bean;

/**
 * ��ƷͼƬ
 * 
 * @author ZhanShiLun
 * @date 2017��9��6�� ����1:59:27
 *
 */
public class ProductImage {
	/**
	 * ��ƷͼƬID
	 */
	private int id;

	/**
	 * ��ƷID
	 */
	private int pid;

	/**
	 * ͼƬ���ͣ�����/���飩
	 */
	private String type;

	/**
	 * ��Ʒ
	 */
	private Product product;

	/**
	 * ��ȡ��ƷͼƬID
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����1:53:03
	 * @return ��ƷͼƬID
	 */
	public int getId() {
		return id;
	}

	/**
	 * ���ò�ƷͼƬID
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����1:53:12
	 * @param id
	 *            ��ƷͼƬID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * ��ȡ��ƷID
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����1:53:19
	 * @return ��ƷID
	 */
	public int getPid() {
		return pid;
	}

	/**
	 * ���ò�ƷID
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����1:53:32
	 * @param pid
	 *            ��ƷID
	 */
	public void setPid(int pid) {
		this.pid = pid;
	}

	/**
	 * ��ȡͼƬ���ͣ�����/���飩
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����1:53:38
	 * @return ͼƬ���ͣ�����/���飩
	 */
	public String getType() {
		return type;
	}

	/**
	 * ����ͼƬ���ͣ�����/���飩
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����1:53:47
	 * @param type
	 *            ͼƬ���ͣ�����/���飩
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * ��ȡ��Ʒ
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����1:53:52
	 * @return ��Ʒ
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * ���ò�Ʒ
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����1:54:02
	 * @param product
	 *            ��Ʒ
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
}
