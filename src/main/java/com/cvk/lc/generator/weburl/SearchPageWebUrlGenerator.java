package com.cvk.lc.generator.weburl;

import com.cvk.lc.common.LinkConversionConstants;
import com.cvk.lc.model.DeeplinkDetails;

public class SearchPageWebUrlGenerator extends AbstractWebUrlGenerator {
	
	public SearchPageWebUrlGenerator(DeeplinkDetails deeplinkDetails) {
		super(deeplinkDetails);
	}

	@Override
	public String generate() {
		StringBuilder sb = new StringBuilder();
		sb.append(LinkConversionConstants.WEB_URL_HOSTNAME);
		sb.append("/sr?q=");
		sb.append(getDeeplinkDetails().getSearchQuery());
		return sb.toString();
	}

}
