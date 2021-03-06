package com.cvk.lc.generator.deeplink;

import com.cvk.lc.common.LinkConversionConstants;
import com.cvk.lc.model.WebUrlDetails;

public class SearchPageDeeplinkGenerator extends AbstractDeeplinkGenerator {
	
	public SearchPageDeeplinkGenerator(WebUrlDetails urlDetails) {
		super(urlDetails);
	}

	@Override
	public String generate() {
		StringBuilder sb = new StringBuilder();
		sb.append(LinkConversionConstants.DEEPLINK_PREFIX);
		sb.append(LinkConversionConstants.SEARCH_PAGE_DEEPLINK_INDICATOR);
		sb.append("=");
		sb.append(getUrlDetails().getRawQuery().substring(2));
		return sb.toString();
	}

}
