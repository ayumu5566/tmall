package tmall.bean;

import java.util.List;

/**
 * ����
 * 
 * @author ZhanShiLun
 * @date 2017��9��5�� ����2:33:29
 *
 */
public class Category {
	/**
	 * ����ID
	 */
	private int id;

	/**
	 * ��������
	 */
	private String name;

	/**
	 * ��Ʒ�б�
	 */
	private List<Product> products;

	/**
	 * TODO
	 */
	private List<List<Product>> productsByRow;

	/**
	 * ��ȡ����ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:27:05
	 * @return ����ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * ���÷���ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:27:26
	 * @param id
	 *            ����ID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * ��ȡ��������
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:27:30
	 * @return ��������
	 */
	public String getName() {
		return name;
	}

	/**
	 * ���÷�������
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:27:47
	 * @param name
	 *            ��������
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��ȡ��Ʒ�б�
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:40:55
	 * @return ��Ʒ�б�
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * ���ò�Ʒ�б�
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:41:05
	 * @param products
	 *            ��Ʒ�б�
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<List<Product>> getProductsByRow() {
		return productsByRow;
	}

	public void setProductsByRow(List<List<Product>> productsByRow) {
		this.productsByRow = productsByRow;
	}

	@Override
	public String toString() {
		return "Category [name = " + name + "]";
	}
}
