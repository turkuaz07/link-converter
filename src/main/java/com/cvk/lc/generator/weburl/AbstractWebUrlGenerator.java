package com.cvk.lc.generator.weburl;

import com.cvk.lc.model.DeeplinkDetails;

public abstract class AbstractWebUrlGenerator implements WebUrlGenerator {
	
	private DeeplinkDetails deeplinkDetails;

	protected AbstractWebUrlGenerator(DeeplinkDetails deeplinkDetails) {
		this.deeplinkDetails = deeplinkDetails;
	}

	public DeeplinkDetails getDeeplinkDetails() {
		return deeplinkDetails;
	}
}
