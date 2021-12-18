package com.trendyol.lc.generator.weburl;

import com.trendyol.lc.model.DeeplinkDetails;

public abstract class AbstractWebUrlGenerator implements WebUrlGenerator {
	
	private DeeplinkDetails deeplinkDetails;

	protected AbstractWebUrlGenerator(DeeplinkDetails deeplinkDetails) {
		this.deeplinkDetails = deeplinkDetails;
	}

	public DeeplinkDetails getDeeplinkDetails() {
		return deeplinkDetails;
	}
}
