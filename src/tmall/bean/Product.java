package tmall.bean;

import java.util.Date;
import java.util.List;

/**
 * ��Ʒ
 * 
 * @author ZhanShiLun
 * @date 2017��9��5�� ����2:33:48
 *
 */
public class Product {
	/**
	 * ��ƷID
	 */
	private int id;

	/**
	 * ����ID
	 */
	private int cid;

	/**
	 * ��Ʒ����
	 */
	private String name;

	/**
	 * С����
	 */
	private String subTitle;

	/**
	 * ԭʼ�۸�
	 */
	private Float orignalPrice;

	/**
	 * �Żݼ۸�
	 */
	private Float promotePrice;

	/**
	 * ���
	 */
	private int stock;

	/**
	 * ��������
	 */
	private Date createDate;

	/**
	 * ����
	 */
	private Category category;

	/**
	 * ��ƷĬ��ͼƬ
	 */
	private ProductImage firstProductImage;

	/**
	 * ��ƷͼƬ�б�
	 */
	private List<ProductImage> productImages;

	/**
	 * ��Ʒ����ͼƬ�б�
	 */
	private List<ProductImage> productSingleImages;

	/**
	 * ��Ʒ����ͼƬ�б�
	 */
	private List<ProductImage> productDetailImages;

	/**
	 * ��������
	 */
	private int reviewCount;

	/**
	 * ��������
	 */
	private int saleCount;

	/**
	 * ��ȡ��ƷID
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:36:17
	 * @return ��ƷID
	 */
	public int getId() {
		return id;
	}

	/**
	 * ���ò�ƷID
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:36:29
	 * @param id
	 *            ��ƷID
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * ��ȡ����ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:36:39
	 * @return ����ID
	 */
	public int getCid() {
		return cid;
	}

	/**
	 * ���÷���ID
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:36:50
	 * @param cid
	 *            ����ID
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}

	/**
	 * ��ȡ��Ʒ����
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:37:05
	 * @return ��Ʒ����
	 */
	public String getName() {
		return name;
	}

	/**
	 * ���ò�Ʒ����
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:37:22
	 * @param name
	 *            ��Ʒ����
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��ȡС����
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:37:31
	 * @return С����
	 */
	public String getSubTitle() {
		return subTitle;
	}

	/**
	 * ����С����
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:37:41
	 * @param subTitle
	 *            С����
	 */
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	/**
	 * ��ȡԭʼ�۸�
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:37:48
	 * @return ԭʼ�۸�
	 */
	public Float getOrignalPrice() {
		return orignalPrice;
	}

	/**
	 * ����ԭʼ�۸�
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:37:56
	 * @param orignalPrice
	 *            ԭʼ�۸�
	 */
	public void setOrignalPrice(Float orignalPrice) {
		this.orignalPrice = orignalPrice;
	}

	/**
	 * ��ȡ�Żݼ۸�
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:38:02
	 * @return �Żݼ۸�
	 */
	public Float getPromotePrice() {
		return promotePrice;
	}

	/**
	 * �����Żݼ۸�
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:38:10
	 * @param promotePrice
	 *            �Żݼ۸�
	 */
	public void setPromotePrice(Float promotePrice) {
		this.promotePrice = promotePrice;
	}

	/**
	 * ��ȡ���
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:38:16
	 * @return ���
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * ���ÿ��
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:38:27
	 * @param stock
	 *            ���
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	/**
	 * ��ȡ��������
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:38:36
	 * @return ��������
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * ���ô�������
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��5�� ����2:38:42
	 * @param createDate
	 *            ��������
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * ��ȡ����
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����1:47:14
	 * @return ����
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * ���÷���
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����1:47:36
	 * @param category
	 *            ����
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * ��ȡ��ƷĬ��ͼƬ
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����1:47:41
	 * @return ��ƷĬ��ͼƬ
	 */
	public ProductImage getFirstProductImage() {
		return firstProductImage;
	}

	/**
	 * ���ò�ƷĬ��ͼƬ
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����1:47:54
	 * @param firstProductImage
	 *            ��ƷĬ��ͼƬ
	 */
	public void setFirstProductImage(ProductImage firstProductImage) {
		this.firstProductImage = firstProductImage;
	}

	/**
	 * ��ȡ��ƷͼƬ�б�
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����1:48:00
	 * @return ��ƷͼƬ�б�
	 */
	public List<ProductImage> getProductImages() {
		return productImages;
	}

	/**
	 * ���ò�ƷͼƬ�б�
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����1:48:13
	 * @param productImages
	 *            ��ƷͼƬ�б�
	 */
	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}

	/**
	 * ��ȡ��Ʒ����ͼƬ�б�
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����1:48:31
	 * @return ��Ʒ����ͼƬ�б�
	 */
	public List<ProductImage> getProductSingleImages() {
		return productSingleImages;
	}

	/**
	 * ���ò�Ʒ����ͼƬ�б�
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����1:48:41
	 * @param productSingleImages
	 *            ��Ʒ����ͼƬ�б�
	 */
	public void setProductSingleImages(List<ProductImage> productSingleImages) {
		this.productSingleImages = productSingleImages;
	}

	/**
	 * ��ȡ��Ʒ����ͼƬ�б�
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����1:49:00
	 * @return ��Ʒ����ͼƬ�б�
	 */
	public List<ProductImage> getProductDetailImages() {
		return productDetailImages;
	}

	/**
	 * ���ò�Ʒ����ͼƬ�б�
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����1:49:05
	 * @param productDetailImages
	 *            ��Ʒ����ͼƬ�б�
	 */
	public void setProductDetailImages(List<ProductImage> productDetailImages) {
		this.productDetailImages = productDetailImages;
	}

	/**
	 * ��ȡ��������
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����1:49:13
	 * @return ��������
	 */
	public int getReviewCount() {
		return reviewCount;
	}

	/**
	 * ������������
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����1:49:25
	 * @param reviewCount
	 *            ��������
	 */
	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

	/**
	 * ��ȡ��������
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����1:49:32
	 * @return ��������
	 */
	public int getSaleCount() {
		return saleCount;
	}

	/**
	 * ������������
	 * 
	 * @author ZhanShiLun
	 * @date 2017��9��6�� ����1:49:43
	 * @param saleCount
	 *            ��������
	 */
	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}
}
