package com.trendyol.lc.data.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.trendyol.lc.model.ProductDetails;

@Document(indexName = "link_conversion_table")
public class LinkConversionTable {

	@Id
	private String deeplink;
	private String webUrl;
	private ProductDetails productDetails;
	
	public String getDeeplink() {
		return deeplink;
	}

	public void setDeeplink(String deeplink) {
		this.deeplink = deeplink;
	}

	public String getWebUrl() {
		return webUrl;
	}

	public void setWebUrl(String webUrl) {
		this.webUrl = webUrl;
	}

	public ProductDetails getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
	}

}
