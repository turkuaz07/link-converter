package com.cvk.lc.generator.weburl;

import org.springframework.util.ObjectUtils;

import com.cvk.lc.common.LinkConversionConstants;
import com.cvk.lc.exception.NoAvailableWebUrlConversionException;
import com.cvk.lc.model.DeeplinkDetails;

public class ProductDetailPageWebUrlGenerator extends AbstractWebUrlGenerator {

	public ProductDetailPageWebUrlGenerator(DeeplinkDetails deeplinkDetails) {
		super(deeplinkDetails);
	}

	@Override
	public String generate() {

		checkPrerequisites();

		StringBuilder sb = new StringBuilder();
		sb.append(LinkConversionConstants.WEB_URL_HOSTNAME);
		sb.append("/");
		sb.append(getBrandName());
		sb.append("/");
		sb.append(getName());
		sb.append("-p-");
		sb.append(getContentId());
		if (boutiqueIdOrMerchantIdExist()) {
			sb.append("?");
			if (!ObjectUtils.isEmpty(getBoutiqueId())) {
				sb.append("boutiqueId=");
				sb.append(getBoutiqueId());
			}

			if (!ObjectUtils.isEmpty(getMerchantId())) {
				if (!ObjectUtils.isEmpty(getBoutiqueId())) {
					sb.append("&");
				}
				sb.append("merchantId=");
				sb.append(getMerchantId());
			}
		}

		return sb.toString();
	}

	private boolean boutiqueIdOrMerchantIdExist() {
		return (!ObjectUtils.isEmpty(getDeeplinkDetails().getCampaignId()) || !ObjectUtils.isEmpty(getDeeplinkDetails().getMerchantId()));
	}

	private String getMerchantId() {
		return getDeeplinkDetails().getMerchantId();
	}

	private String getBoutiqueId() {
		return getDeeplinkDetails().getCampaignId();
	}

	private String getContentId() {
		return getDeeplinkDetails().getWebUrlConversionTable().getProductDetails().getContentId();
	}

	private String getBrandName() {
		return getDeeplinkDetails().getWebUrlConversionTable().getProductDetails().getBrandOrCategoryName();
	}

	private String getName() {
		return getDeeplinkDetails().getWebUrlConversionTable().getProductDetails().getProductName();
	}

	private void checkPrerequisites() {
		if (getDeeplinkDetails().getWebUrlConversionTable() == null)
			throw new NoAvailableWebUrlConversionException();
	}
}
