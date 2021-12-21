package com.cvk.lc.generator.deeplink;

import com.cvk.lc.model.WebUrlDetails;

public abstract class AbstractDeeplinkGenerator implements DeeplinkGenerator {
	
	private WebUrlDetails urlDetails;

	protected AbstractDeeplinkGenerator(WebUrlDetails urlDetails) {
		this.urlDetails = urlDetails;
	}

	public WebUrlDetails getUrlDetails() {
		return urlDetails;
	}	
}
