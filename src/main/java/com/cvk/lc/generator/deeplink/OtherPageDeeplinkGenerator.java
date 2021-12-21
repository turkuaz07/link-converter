package com.cvk.lc.generator.deeplink;

import com.cvk.lc.common.LinkConversionConstants;
import com.cvk.lc.model.WebUrlDetails;

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
