package com.trendyol.lc.generator.deeplink;

import com.trendyol.lc.common.LinkConversionConstants;
import com.trendyol.lc.model.WebUrlDetails;

public class OtherPageDeeplinkGenerator extends AbstractDeeplinkGenerator {
	
	public OtherPageDeeplinkGenerator(WebUrlDetails urlDetails) {
		super(urlDetails);
	}

	@Override
	public String generate() {
		StringBuilder sb = new StringBuilder();
		sb.append(LinkConversionConstants.DEEPLINK_PREFIX);
		sb.append("Home");
		return sb.toString();
	}

}
