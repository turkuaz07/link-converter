package com.cvk.lc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cvk.lc.common.WebUrlParser;
import com.cvk.lc.model.WebUrlDetails;
import com.cvk.lc.type.WebUrlType;

@ExtendWith(MockitoExtension.class)
class WebUrlParserTests {

	@Test
	void webUrlParse() {
		
		String request = "https://www.cvk.com/defacto/erkek-bebek-regular-fit-bisiklet-yaka-yilbasi-temali-geyik-baskili-2-li-takim-p-194728985?boutiqueId=592457&merchantId=1188";
		
		WebUrlDetails expectedWebUrlDetails = new WebUrlDetails();
		expectedWebUrlDetails.setBrandOrCategoryName("defacto");
		expectedWebUrlDetails.setContentId("194728985");
		expectedWebUrlDetails.setProductName("erkek-bebek-regular-fit-bisiklet-yaka-yilbasi-temali-geyik-baskili-2-li-takim");
		expectedWebUrlDetails.setRawQuery("boutiqueId=592457&merchantId=1188");
		expectedWebUrlDetails.setUrlType(WebUrlType.PRODUCT_DETAIL_PAGE_URL);
		Map<String, String> queryParams = new HashMap<>();
		queryParams.put("boutiqueId", "592457");
		queryParams.put("merchantId", "1188");
		expectedWebUrlDetails.setQueryParams(queryParams);
		
		assertEquals(expectedWebUrlDetails, WebUrlParser.parse(request));
	}
}
