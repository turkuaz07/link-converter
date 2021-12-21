package com.cvk.lc.generator.weburl;

import com.cvk.lc.model.DeeplinkDetails;
import com.cvk.lc.type.DeeplinkType;

public class WebUrlFactory {
	
	private WebUrlFactory() {
		super();
	}

	public static WebUrlGenerator getDeeplinkGenerator(DeeplinkDetails deeplinkDetails) {

		if (deeplinkDetails.getDeeplinkType() == DeeplinkType.PRODUCT_DETAIL_PAGE_LINK) {
			return new ProductDetailPageWebUrlGenerator(deeplinkDetails);
		} else if (deeplinkDetails.getDeeplinkType() == DeeplinkType.SEARCH_PAGE_LINK) {
			return new SearchPageWebUrlGenerator(deeplinkDetails);
		} else {
			return new OtherPageWebUrlGenerator(deeplinkDetails);
		}
	}
}
