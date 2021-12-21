package com.cvk.lc.common;

import com.cvk.lc.type.DeeplinkType;

public class DeeplinkTypeDeterminer {
	
	private DeeplinkTypeDeterminer() {
		super();
	}

	public static DeeplinkType determine(String deeplink) {
		if (deeplink.contains(LinkConversionConstants.PRODUCT_DETAIL_PAGE_DEEPLINK_INDICATOR))
			return DeeplinkType.PRODUCT_DETAIL_PAGE_LINK;
		else if (deeplink.contains(LinkConversionConstants.SEARCH_PAGE_DEEPLINK_INDICATOR))
			return DeeplinkType.SEARCH_PAGE_LINK;
		else
			return DeeplinkType.OTHER_PAGE_LINK;
	}
}
