package tmall.bean;

import java.util.List;

/**
 * 分类
 * 
 * @author ZhanShiLun
 * @date 2017年9月5日 下午2:33:29
 *
 */
public class Category {
	/**
	 * 分类ID
	 */
	private int id;

	/**
	 * 分类名称
	 */
	private String name;

	/**
	 * 产品列表
	 */
	private List<Product> products;

	/**
	 * TODO
	 */
	private List<List<Product>> productsByRow;

	/**
	 * 获取分类ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:27:05
	 * @return 分类ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置分类ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:27:26
	 * @param id
	 *            分类ID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取分类名称
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:27:30
	 * @return 分类名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置分类名称
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:27:47
	 * @param name
	 *            分类名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取产品列表
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:40:55
	 * @return 产品列表
	 */
	public List<Product> getProducts() {
		return products;
	}

	/**
	 * 设置产品列表
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:41:05
	 * @param products
	 *            产品列表
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
