package tmall.bean;

import java.util.Date;
import java.util.List;

/**
 * 产品
 * 
 * @author ZhanShiLun
 * @date 2017年9月5日 下午2:33:48
 *
 */
public class Product {
	/**
	 * 产品ID
	 */
	private int id;

	/**
	 * 分类ID
	 */
	private int cid;

	/**
	 * 产品名称
	 */
	private String name;

	/**
	 * 小标题
	 */
	private String subTitle;

	/**
	 * 原始价格
	 */
	private Float orignalPrice;

	/**
	 * 优惠价格
	 */
	private Float promotePrice;

	/**
	 * 库存
	 */
	private int stock;

	/**
	 * 创建日期
	 */
	private Date createDate;

	/**
	 * 分类
	 */
	private Category category;

	/**
	 * 产品默认图片
	 */
	private ProductImage firstProductImage;

	/**
	 * 产品图片列表
	 */
	private List<ProductImage> productImages;

	/**
	 * 产品单个图片列表
	 */
	private List<ProductImage> productSingleImages;

	/**
	 * 产品详情图片列表
	 */
	private List<ProductImage> productDetailImages;

	/**
	 * 评价数量
	 */
	private int reviewCount;

	/**
	 * 销售数量
	 */
	private int saleCount;

	/**
	 * 获取产品ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:36:17
	 * @return 产品ID
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置产品ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:36:29
	 * @param id
	 *            产品ID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取分类ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:36:39
	 * @return 分类ID
	 */
	public int getCid() {
		return cid;
	}

	/**
	 * 设置分类ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:36:50
	 * @param cid
	 *            分类ID
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}

	/**
	 * 获取产品名称
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:37:05
	 * @return 产品名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置产品名称
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:37:22
	 * @param name
	 *            产品名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取小标题
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:37:31
	 * @return 小标题
	 */
	public String getSubTitle() {
		return subTitle;
	}

	/**
	 * 设置小标题
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:37:41
	 * @param subTitle
	 *            小标题
	 */
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	/**
	 * 获取原始价格
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:37:48
	 * @return 原始价格
	 */
	public Float getOrignalPrice() {
		return orignalPrice;
	}

	/**
	 * 设置原始价格
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:37:56
	 * @param orignalPrice
	 *            原始价格
	 */
	public void setOrignalPrice(Float orignalPrice) {
		this.orignalPrice = orignalPrice;
	}

	/**
	 * 获取优惠价格
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:38:02
	 * @return 优惠价格
	 */
	public Float getPromotePrice() {
		return promotePrice;
	}

	/**
	 * 设置优惠价格
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:38:10
	 * @param promotePrice
	 *            优惠价格
	 */
	public void setPromotePrice(Float promotePrice) {
		this.promotePrice = promotePrice;
	}

	/**
	 * 获取库存
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:38:16
	 * @return 库存
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * 设置库存
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:38:27
	 * @param stock
	 *            库存
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * 获取创建日期
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:38:36
	 * @return 创建日期
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 设置创建日期
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月5日 下午2:38:42
	 * @param createDate
	 *            创建日期
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 获取分类
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午1:47:14
	 * @return 分类
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * 设置分类
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午1:47:36
	 * @param category
	 *            分类
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * 获取产品默认图片
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午1:47:41
	 * @return 产品默认图片
	 */
	public ProductImage getFirstProductImage() {
		return firstProductImage;
	}

	/**
	 * 设置产品默认图片
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午1:47:54
	 * @param firstProductImage
	 *            产品默认图片
	 */
	public void setFirstProductImage(ProductImage firstProductImage) {
		this.firstProductImage = firstProductImage;
	}

	/**
	 * 获取产品图片列表
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午1:48:00
	 * @return 产品图片列表
	 */
	public List<ProductImage> getProductImages() {
		return productImages;
	}

	/**
	 * 设置产品图片列表
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午1:48:13
	 * @param productImages
	 *            产品图片列表
	 */
	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}

	/**
	 * 获取产品单个图片列表
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午1:48:31
	 * @return 产品单个图片列表
	 */
	public List<ProductImage> getProductSingleImages() {
		return productSingleImages;
	}

	/**
	 * 设置产品单个图片列表
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午1:48:41
	 * @param productSingleImages
	 *            产品单个图片列表
	 */
	public void setProductSingleImages(List<ProductImage> productSingleImages) {
		this.productSingleImages = productSingleImages;
	}

	/**
	 * 获取产品详情图片列表
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午1:49:00
	 * @return 产品详情图片列表
	 */
	public List<ProductImage> getProductDetailImages() {
		return productDetailImages;
	}

	/**
	 * 设置产品详情图片列表
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午1:49:05
	 * @param productDetailImages
	 *            产品详情图片列表
	 */
	public void setProductDetailImages(List<ProductImage> productDetailImages) {
		this.productDetailImages = productDetailImages;
	}

	/**
	 * 获取评价数量
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午1:49:13
	 * @return 评价数量
	 */
	public int getReviewCount() {
		return reviewCount;
	}

	/**
	 * 设置评价数量
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午1:49:25
	 * @param reviewCount
	 *            评价数量
	 */
	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	/**
	 * 获取销售数量
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午1:49:32
	 * @return 销售数量
	 */
	public int getSaleCount() {
		return saleCount;
	}

	/**
	 * 设置销售数量
	 * 
	 * @author ZhanShiLun
	 * @date 2017年9月6日 下午1:49:43
	 * @param saleCount
	 *            销售数量
	 */
	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}
}
