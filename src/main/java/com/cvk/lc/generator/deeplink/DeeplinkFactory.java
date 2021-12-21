package com.cvk.lc.generator.deeplink;

import com.cvk.lc.model.WebUrlDetails;
import com.cvk.lc.type.WebUrlType;

public class DeeplinkFactory {

	private DeeplinkFactory() {
		super();
	}

	public static DeeplinkGenerator getDeeplinkGenerator(WebUrlDetails urlDetails) {

		if (urlDetails.getUrlType() == WebUrlType.PRODUCT_DETAIL_PAGE_URL) {
			return new ProductDetailPageDeeplinkGenerator(urlDetails);
		} else if (urlDetails.getUrlType() == WebUrlType.SEARCH_PAGE_URL) {
			return new SearchPageDeeplinkGenerator(urlDetails);
		} else {
			return new OtherPageDeeplinkGenerator(urlDetails);
		}
	}
}
