package com.trendyol.lc;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.elasticsearch.core.SearchHit;

import com.trendyol.lc.data.document.LinkConversionTable;
import com.trendyol.lc.data.service.LinkConversionTableSearchService;
import com.trendyol.lc.exception.NoAvailableWebUrlConversionException;
import com.trendyol.lc.model.DeeplinkDetails;
import com.trendyol.lc.service.LinkConversionService;

@ExtendWith(MockitoExtension.class)
class LinkConversionServiceUnexpectedTests {

	@InjectMocks
	LinkConversionService linkConversionService;

	@Mock
	LinkConversionTableSearchService linkConversionTableSearchService;

	@Test
	void convertToWebUrl() {
		
		String request = "ty://?Page=Product&ContentId=194728985&CampaignId=592457&MerchantId=11886495689458946496946468";
		
		SearchHit<LinkConversionTable> mockSearchHit = new SearchHit<LinkConversionTable>(null, null, null, 0, null, null, null, null, null, null, null);

		Mockito.when(linkConversionTableSearchService.search(Mockito.any(DeeplinkDetails.class))).thenReturn(mockSearchHit);
		
		assertThrows(NoAvailableWebUrlConversionException.class, () -> {
			linkConversionService.convertToWebUrl(request);
		});
	}
}
