package com.cvk.lc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cvk.lc.common.DeeplinkParser;
import com.cvk.lc.model.DeeplinkDetails;
import com.cvk.lc.type.DeeplinkType;

@ExtendWith(MockitoExtension.class)
class DeeplinkParserTests {

	@Test
	void deeplinkParse() {
		
		String request = "ty://?Page=Product&ContentId=194728985&CampaignId=592457&MerchantId=1188";
		
		DeeplinkDetails expectedDeeplinkDetails = new DeeplinkDetails();
		expectedDeeplinkDetails.setDeeplinkType(DeeplinkType.PRODUCT_DETAIL_PAGE_LINK);
		expectedDeeplinkDetails.setContentId("194728985");
		expectedDeeplinkDetails.setCampaignId("592457");
		expectedDeeplinkDetails.setMerchantId("1188");
		
		assertEquals(expectedDeeplinkDetails, DeeplinkParser.parse(request));
	}
}
