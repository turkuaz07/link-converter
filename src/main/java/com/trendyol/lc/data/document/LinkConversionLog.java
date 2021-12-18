package com.trendyol.lc.data.document;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "link_conversion_log")
public class LinkConversionLog {

	@Id
	private String id = UUID.randomUUID().toString();

	private String request;
	private String response;
	private LocalDateTime requestDateTime;
	private long responseDurationInMs;

	public String getRequest() {
		return request;
	}

	public LinkConversionLog setRequest(String request) {
		this.request = request;
		return this;
	}

	public String getResponse() {
		return response;
	}

	public LinkConversionLog setResponse(String response) {
		this.response = response;
		return this;
	}

	public LocalDateTime getRequestDateTime() {
		return requestDateTime;
	}

	public LinkConversionLog setRequestDateTime(LocalDateTime requestDateTime) {
		this.requestDateTime = requestDateTime;
		return this;
	}

	public long getResponseDurationInMs() {
		return responseDurationInMs;
	}

	public LinkConversionLog setResponseDurationInMs(long responseDurationInMs) {
		this.responseDurationInMs = responseDurationInMs;
		return this;
	}

}
