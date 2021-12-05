package com.trendyol.lc.model;

import com.trendyol.lc.data.document.LinkConversionLog;

public class ConversionResult {

	private String convertedTo;
	private LinkConversionLog conversionLog = new LinkConversionLog();
	
	public ConversionResult(String convertedTo) {
		this.convertedTo = convertedTo;
	}

	public String getConvertedTo() {
		return convertedTo;
	}

	public LinkConversionLog getConversionLog() {
		return conversionLog;
	}
}
