package com.trendyol.lc.model;

import com.trendyol.lc.data.document.LinkConversionTable;
import com.trendyol.lc.type.DeeplinkType;

public class DeeplinkDetails {

	private DeeplinkType deeplinkType;
	private String contentId;
	private String campaignId;
	private String merchantId;
	private String searchQuery;

	private LinkConversionTable webUrlConversionTable;

	public DeeplinkType getDeeplinkType() {
		return deeplinkType;
	}

	public void setDeeplinkType(DeeplinkType deeplinkType) {
		this.deeplinkType = deeplinkType;
	}

	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public String getCampaignId() {
		return campaignId;
	}

	public void setCampaignId(String campaignId) {
		this.campaignId = campaignId;
	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getSearchQuery() {
		return searchQuery;
	}

	public void setSearchQuery(String searchQuery) {
		this.searchQuery = searchQuery;
	}

	public LinkConversionTable getWebUrlConversionTable() {
		return webUrlConversionTable;
	}

	public void setWebUrlConversionTable(LinkConversionTable webUrlConversionTable) {
		this.webUrlConversionTable = webUrlConversionTable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campaignId == null) ? 0 : campaignId.hashCode());
		result = prime * result + ((contentId == null) ? 0 : contentId.hashCode());
		result = prime * result + ((merchantId == null) ? 0 : merchantId.hashCode());
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
		DeeplinkDetails other = (DeeplinkDetails) obj;
		if (campaignId == null) {
			if (other.campaignId != null)
				return false;
		} else if (!campaignId.equals(other.campaignId))
			return false;
		if (contentId == null) {
			if (other.contentId != null)
				return false;
		} else if (!contentId.equals(other.contentId))
			return false;
		if (merchantId == null) {
			if (other.merchantId != null)
				return false;
		} else if (!merchantId.equals(other.merchantId))
			return false;
		return true;
	}
}
