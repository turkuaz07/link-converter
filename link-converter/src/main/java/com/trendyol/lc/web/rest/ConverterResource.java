package com.trendyol.lc.web.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trendyol.lc.annotation.ValidWebUrl;
import com.trendyol.lc.log.LinkConversionTxLogger;
import com.trendyol.lc.model.ConversionResult;
import com.trendyol.lc.service.LinkConversionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Validated
@RestController
@RequestMapping("/api/conversion")
public class ConverterResource {

	@Autowired
	private LinkConversionService linkConversionService;

	@Autowired
	private LinkConversionTxLogger txLogger;

	@Operation(summary = "Convert web url to deeplink")
	@ApiResponses(value = { 
			@ApiResponse(responseCode = "200", description = "Successfully converted"),
			@ApiResponse(responseCode = "400", description = "Invalid/unacceptable web url address!"), 
	})
	@PostMapping(value="/toDeeplink", produces=MediaType.TEXT_PLAIN_VALUE, consumes = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> convertToDeeplink(@RequestBody @ValidWebUrl String webUrl) {
		
		LocalDateTime requestDateTime = LocalDateTime.now();
		long start = System.currentTimeMillis();
		
		ConversionResult conversionResult = linkConversionService.convertToDeeplink(webUrl);
		
		conversionResult.getConversionLog().setRequest(webUrl).setResponse(conversionResult.getConvertedTo()).setRequestDateTime(requestDateTime).setResponseDurationInMs(System.currentTimeMillis() - start);
		txLogger.log(conversionResult.getConversionLog());
		
		return ResponseEntity.ok().body(conversionResult.getConvertedTo());
	}
}
