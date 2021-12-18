package com.trendyol.lc.generator.weburl;

import com.trendyol.lc.common.LinkConversionConstants;
import com.trendyol.lc.model.DeeplinkDetails;

public class OtherPageWebUrlGenerator extends AbstractWebUrlGenerator {
	
	public OtherPageWebUrlGenerator(DeeplinkDetails deeplinkDetails) {
		super(deeplinkDetails);
	}

	@Override
	public String generate() {
		return LinkConversionConstants.WEB_URL_HOSTNAME;
	}

}
