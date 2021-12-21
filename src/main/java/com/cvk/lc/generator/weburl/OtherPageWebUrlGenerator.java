package com.cvk.lc.generator.weburl;

import com.cvk.lc.common.LinkConversionConstants;
import com.cvk.lc.model.DeeplinkDetails;

public class OtherPageWebUrlGenerator extends AbstractWebUrlGenerator {
	
	public OtherPageWebUrlGenerator(DeeplinkDetails deeplinkDetails) {
		super(deeplinkDetails);
	}

	@Override
	public String generate() {
		return LinkConversionConstants.WEB_URL_HOSTNAME;
	}

}
