package com.trendyol.lc.model;

public class ProductDetails {

	private String contentId;
	private String brandOrCategoryName;
	private String productName;
	private String boutiqueId;
	private String merchantId;

	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public String getBrandOrCategoryName() {
		return brandOrCategoryName;
	}

	public void setBrandOrCategoryName(String brandOrCategoryName) {
		this.brandOrCategoryName = brandOrCategoryName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getBoutiqueId() {
		return boutiqueId;
	}

	public void setBoutiqueId(String boutiqueId) {
		this.boutiqueId = boutiqueId;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}
}
