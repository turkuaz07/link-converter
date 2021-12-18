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

import com.trendyol.lc.exception.NoAvailableWebUrlConversionException;
import com.trendyol.lc.log.LinkConversionTxLogger;
import com.trendyol.lc.service.LinkConversionService;
import com.trendyol.lc.web.rest.ConverterResource;

@WebMvcTest(ConverterResource.class)
class ConverterResourceUnexpectedTests {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	LinkConversionService linkConversionService;

	@MockBean
	LinkConversionTxLogger linkConversionTxLogger;
	
	@Test
	void convertToDeeplink() throws Exception {

		String request1 = "this is not a web url";
		performConvertToDeeplinkTest(request1);
		
		String request2 = "https://www.hepsiburada.com/ara?q=kablo+tesisat+gizleme";
		performConvertToDeeplinkTest(request2);
	}
	
	void performConvertToDeeplinkTest(String request) throws Exception {
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/conversion/toDeeplink").content(request).contentType(MediaType.TEXT_PLAIN_VALUE);
		mockMvc.perform(mockRequest).andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	void convertToWebUrl_test1() throws Exception {

		String request1 = "this is not a deeplink";
		performConvertToDeeplinkTest(request1);
		
		String request2 = "hb://?Page=Product&ContentId=194728985&CampaignId=592457&MerchantId=1188";
		performConvertToDeeplinkTest(request2);
	}
	
	void performConvertToWebUrlTest1(String request) throws Exception {
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/conversion/toWebUrl").content(request).contentType(MediaType.TEXT_PLAIN_VALUE);
		mockMvc.perform(mockRequest).andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	void convertToWebUrl_test2() throws Exception {
		
		String request = "ty://?Page=Product&ContentId=194728985&CampaignId=592457&MerchantId=11886495689458946496946468";
		
		Mockito.when(linkConversionService.convertToWebUrl(request)).thenThrow(NoAvailableWebUrlConversionException.class);
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/conversion/toWebUrl").content(request).contentType(MediaType.TEXT_PLAIN_VALUE);
		mockMvc.perform(mockRequest).andExpect(MockMvcResultMatchers.status().isNotFound());
	}
}
