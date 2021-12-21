package com.cvk.lc.model;

import java.util.Map;

import com.cvk.lc.type.WebUrlType;

public class WebUrlDetails {

	private WebUrlType urlType;
	private String brandOrCategoryName;
	private String productName;
	private String contentId;
	private Map<String, String> queryParams;
	private String rawQuery;

	public WebUrlType getUrlType() {
		return urlType;
	}

	public void setUrlType(WebUrlType urlType) {
		this.urlType = urlType;
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

	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public Map<String, String> getQueryParams() {
		return queryParams;
	}

	public void setQueryParams(Map<String, String> queryParams) {
		this.queryParams = queryParams;
	}

	public String getRawQuery() {
		return rawQuery;
	}

	public void setRawQuery(String rawQuery) {
		this.rawQuery = rawQuery;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contentId == null) ? 0 : contentId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WebUrlDetails other = (WebUrlDetails) obj;
		if (contentId == null) {
			if (other.contentId != null)
				return false;
		} else if (!contentId.equals(other.contentId))
			return false;
		if (queryParams == null) {
			if (other.queryParams != null)
				return false;
		} else if (!areEqual(queryParams, other.getQueryParams()))
			return false;
		return true;
	}
	
	private boolean areEqual(Map<String, String> first, Map<String, String> second) {
	    if (first.size() != second.size()) {
	        return false;
	    }

	    return first.entrySet().stream()
	      .allMatch(e -> e.getValue().equals(second.get(e.getKey())));
	}
	
}
