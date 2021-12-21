package com.cvk.lc.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cvk.lc.model.DeeplinkDetails;
import com.cvk.lc.type.DeeplinkType;

public class DeeplinkParser {
	
	private DeeplinkParser() {
		super();
	}

	public static DeeplinkDetails parse(String deeplink) {

		DeeplinkDetails deeplinkDetails = new DeeplinkDetails();
		DeeplinkType deeplinkType = DeeplinkTypeDeterminer.determine(deeplink);
		deeplinkDetails.setDeeplinkType(deeplinkType);

		String deeplinkWithoutPrefix = deeplink.replace(LinkConversionConstants.DEEPLINK_PREFIX, "");

		if (deeplinkType == DeeplinkType.PRODUCT_DETAIL_PAGE_LINK) {
			deeplinkDetails.setContentId(getValueByParam(deeplinkWithoutPrefix, LinkConversionConstants.PRODUCT_DETAIL_PAGE_DEEPLINK_INDICATOR));
			deeplinkDetails.setCampaignId(getValueByParam(deeplinkWithoutPrefix, LinkConversionConstants.DEEPLINK_CAMPAIGN_ID_PARAM));
			deeplinkDetails.setMerchantId(getValueByParam(deeplinkWithoutPrefix, LinkConversionConstants.DEEPLINK_MERCHANT_ID_PARAM));
		} else if (deeplinkType == DeeplinkType.SEARCH_PAGE_LINK) {
			String searchQuery = deeplinkWithoutPrefix.replace(LinkConversionConstants.SEARCH_PAGE_DEEPLINK_INDICATOR + "=", "");
			deeplinkDetails.setSearchQuery(searchQuery);
		}

		return deeplinkDetails;
	}

	private static String getValueByParam(String text, String param) {
		Pattern p = Pattern.compile("(" + param + "=[0-9]+)");
		Matcher m = p.matcher(text);
		if (m.find()) {
			return m.group(1).split("=")[1];
		}
		return "";
	}
}
