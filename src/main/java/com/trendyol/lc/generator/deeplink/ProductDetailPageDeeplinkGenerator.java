package com.trendyol.lc.generator.deeplink;

import com.trendyol.lc.common.LinkConversionConstants;
import com.trendyol.lc.model.WebUrlDetails;

public class ProductDetailPageDeeplinkGenerator extends AbstractDeeplinkGenerator {
	
	public ProductDetailPageDeeplinkGenerator(WebUrlDetails urlDetails) {
		super(urlDetails);
	}

	@Override
	public String generate() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(LinkConversionConstants.DEEPLINK_PREFIX);
		sb.append(LinkConversionConstants.PRODUCT_DETAIL_PAGE_DEEPLINK_INDICATOR);
		
		sb.append("=");
		sb.append(getUrlDetails().getContentId());
		
		if(getUrlDetails().getQueryParams() != null) {
			if(getUrlDetails().getQueryParams().get(LinkConversionConstants.WEB_URL_BOUTIQUE_ID_PARAM) != null) {
				sb.append("&");
				sb.append(LinkConversionConstants.DEEPLINK_CAMPAIGN_ID_PARAM);
				sb.append("=");
				sb.append(getUrlDetails().getQueryParams().get(LinkConversionConstants.WEB_URL_BOUTIQUE_ID_PARAM));
			}
			if(getUrlDetails().getQueryParams().get(LinkConversionConstants.WEB_URL_MERCHANT_ID_PARAM) != null) {
				sb.append("&");
				sb.append(LinkConversionConstants.DEEPLINK_MERCHANT_ID_PARAM);
				sb.append("=");
				sb.append(getUrlDetails().getQueryParams().get(LinkConversionConstants.WEB_URL_MERCHANT_ID_PARAM));
			}
		}
		return sb.toString();
	}

}
