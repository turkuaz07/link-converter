package com.trendyol.lc.common;

import com.trendyol.lc.type.WebUrlType;

public class WebUrlTypeDeterminer {
	
	private WebUrlTypeDeterminer() {
		super();
	}

	public static WebUrlType determine(String url) {
		if (RegexUtil.anyMatch(LinkConversionConstants.PRODUCT_DETAIL_PAGE_URL_REGEX, url))
			return WebUrlType.PRODUCT_DETAIL_PAGE_URL;
		else if (RegexUtil.anyMatch(LinkConversionConstants.SEARCH_PAGE_URL_REGEX, url))
			return WebUrlType.SEARCH_PAGE_URL;
		else
			return WebUrlType.OTHER_PAGE_URL;
	}
}
