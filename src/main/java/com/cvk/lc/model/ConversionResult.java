package com.cvk.lc.model;

import com.cvk.lc.data.document.LinkConversionLog;

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
