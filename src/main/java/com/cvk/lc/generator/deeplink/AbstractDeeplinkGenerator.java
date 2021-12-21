package com.trendyol.lc.generator.deeplink;

import com.trendyol.lc.model.WebUrlDetails;

public abstract class AbstractDeeplinkGenerator implements DeeplinkGenerator {
	
	private WebUrlDetails urlDetails;

	protected AbstractDeeplinkGenerator(WebUrlDetails urlDetails) {
		this.urlDetails = urlDetails;
	}

	public WebUrlDetails getUrlDetails() {
		return urlDetails;
	}	
}
