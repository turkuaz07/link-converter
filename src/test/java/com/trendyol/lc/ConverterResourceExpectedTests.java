package com.trendyol.lc;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.trendyol.lc.log.LinkConversionTxLogger;
import com.trendyol.lc.model.ConversionResult;
import com.trendyol.lc.service.LinkConversionService;
import com.trendyol.lc.web.rest.ConverterResource;

@WebMvcTest(ConverterResource.class)
class ConverterResourceExpectedTests {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	LinkConversionService linkConversionService;

	@MockBean
	LinkConversionTxLogger linkConversionTxLogger;

	@Test
	void convertProductDetailPageWebUrlToDeeplink_test1() throws Exception {

		String request = "https://www.trendyol.com/defacto/erkek-bebek-regular-fit-bisiklet-yaka-yilbasi-temali-geyik-baskili-2-li-takim-p-194728985?boutiqueId=592457&merchantId=1188";
		String mockResponse = "ty://?Page=Product&ContentId=194728985&CampaignId=592457&MerchantId=1188";
		String expectedResponse = "ty://?Page=Product&ContentId=194728985&CampaignId=592457&MerchantId=1188";

		ConversionResult conversionResult = new ConversionResult(mockResponse);

		Mockito.when(linkConversionService.convertToDeeplink(request)).thenReturn(conversionResult);

		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/conversion/toDeeplink").content(request).contentType(MediaType.TEXT_PLAIN_VALUE);

		mockMvc.perform(mockRequest).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string(expectedResponse));
	}
}
