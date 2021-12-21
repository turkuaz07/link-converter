package com.cvk.lc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.elasticsearch.core.SearchHit;

import com.cvk.lc.data.document.LinkConversionTable;
import com.cvk.lc.data.repo.LinkConversionTableRepository;
import com.cvk.lc.data.service.LinkConversionTableSearchService;
import com.cvk.lc.model.DeeplinkDetails;
import com.cvk.lc.model.ProductDetails;
import com.cvk.lc.service.LinkConversionService;

@ExtendWith(MockitoExtension.class)
class LinkConversionServiceExpectedTests {

	@InjectMocks
	LinkConversionService linkConversionService;

	@Mock
	LinkConversionTableSearchService linkConversionTableSearchService;
	
	@Mock
	LinkConversionTableRepository linkConversionTableRepository;
	
	@Test
	void convertToDeeplink() throws Exception {

		String request1 = "https://www.cvk.com/defacto/erkek-bebek-regular-fit-bisiklet-yaka-yilbasi-temali-geyik-baskili-2-li-takim-p-194728985?boutiqueId=592457&merchantId=1188";
		String expectedResponse1 = "ty://?Page=Product&ContentId=194728985&CampaignId=592457&MerchantId=1188";
		performConvertToDeeplinkTest(request1, expectedResponse1);

		String request2 = "https://www.cvk.com/defacto/erkek-bebek-regular-fit-bisiklet-yaka-yilbasi-temali-geyik-baskili-2-li-takim-p-194728985";
		String expectedResponse2 = "ty://?Page=Product&ContentId=194728985";
		performConvertToDeeplinkTest(request2, expectedResponse2);

		String request3 = "https://www.cvk.com/defacto/erkek-bebek-regular-fit-bisiklet-yaka-yilbasi-temali-geyik-baskili-2-li-takim-p-194728985?boutiqueId=592457";
		String expectedResponse3 = "ty://?Page=Product&ContentId=194728985&CampaignId=592457";
		performConvertToDeeplinkTest(request3, expectedResponse3);

		String request4 = "https://www.cvk.com/defacto/erkek-bebek-regular-fit-bisiklet-yaka-yilbasi-temali-geyik-baskili-2-li-takim-p-194728985?merchantId=1188";
		String expectedResponse4 = "ty://?Page=Product&ContentId=194728985&MerchantId=1188";
		performConvertToDeeplinkTest(request4, expectedResponse4);

		String request5 = "https://www.cvk.com/sr?q=elbise&qt=elbise&st=elbise&os=1";
		String expectedResponse5 = "ty://?Page=Search&Query=elbise&qt=elbise&st=elbise&os=1";
		performConvertToDeeplinkTest(request5, expectedResponse5);

		String request6 = "https://www.cvk.com/Hesabim/Favoriler";
		String expectedResponse6 = "ty://?Page=Home";
		performConvertToDeeplinkTest(request6, expectedResponse6);
	}

	void performConvertToDeeplinkTest(String request, String expectedResponse) throws Exception {
		assertEquals(expectedResponse, linkConversionService.convertToDeeplink(request).getConvertedTo());
	}

	@Test
	void convertToWebUrl() throws Exception {
		
		String request = "ty://?Page=Product&ContentId=194728985&CampaignId=592457&MerchantId=1188";
		String expectedResponse = "https://www.cvk.com/defacto/erkek-bebek-regular-fit-bisiklet-yaka-yilbasi-temali-geyik-baskili-2-li-takim-p-194728985?boutiqueId=592457&merchantId=1188";
		
		LinkConversionTable mockConversionTable = new LinkConversionTable();
		mockConversionTable.setDeeplink(request);
		mockConversionTable.setWebUrl(expectedResponse);
		ProductDetails productDetails = new ProductDetails();
		productDetails.setProductName("erkek-bebek-regular-fit-bisiklet-yaka-yilbasi-temali-geyik-baskili-2-li-takim");
		productDetails.setBrandOrCategoryName("defacto");
		productDetails.setContentId("194728985");
		productDetails.setBoutiqueId("592457");
		productDetails.setMerchantId("1188");
		mockConversionTable.setProductDetails(productDetails);
		SearchHit<LinkConversionTable> mockSearchHit = new SearchHit<LinkConversionTable>(null, null, null, 1, null, null, null, null, null, null, mockConversionTable);
		
		Mockito.when(linkConversionTableSearchService.search(Mockito.any(DeeplinkDetails.class))).thenReturn(mockSearchHit);
		
		assertEquals(expectedResponse, linkConversionService.convertToWebUrl(request).getConvertedTo());
	}
}
