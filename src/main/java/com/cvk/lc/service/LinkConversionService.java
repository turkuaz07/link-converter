package com.cvk.lc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.stereotype.Service;

import com.cvk.lc.common.DeeplinkParser;
import com.cvk.lc.common.LinkConversionConstants;
import com.cvk.lc.common.WebUrlParser;
import com.cvk.lc.data.document.LinkConversionTable;
import com.cvk.lc.data.repo.LinkConversionTableRepository;
import com.cvk.lc.data.service.LinkConversionTableSearchService;
import com.cvk.lc.generator.deeplink.DeeplinkFactory;
import com.cvk.lc.generator.deeplink.DeeplinkGenerator;
import com.cvk.lc.generator.weburl.WebUrlFactory;
import com.cvk.lc.generator.weburl.WebUrlGenerator;
import com.cvk.lc.model.ConversionResult;
import com.cvk.lc.model.DeeplinkDetails;
import com.cvk.lc.model.ProductDetails;
import com.cvk.lc.model.WebUrlDetails;
import com.cvk.lc.type.DeeplinkType;

@Service
public class LinkConversionService {

	@Autowired
	private LinkConversionTableRepository linkConversionTableRepository;

	@Autowired
	private LinkConversionTableSearchService linkConversionTableSearchService;

	public ConversionResult convertToDeeplink(String webUrl) {

		WebUrlDetails webUrlDetails = getWebUrlDetails(webUrl);

		DeeplinkGenerator deeplinkGenerator = DeeplinkFactory.getDeeplinkGenerator(webUrlDetails);
		String deeplink = deeplinkGenerator.generate();

		linkConversionTableRepository.save(populateLinkConversionTable(webUrl, deeplink, webUrlDetails));

		return new ConversionResult(deeplink);
	}

	public ConversionResult convertToWebUrl(String deeplink) {

		DeeplinkDetails deeplinkDetails = getDeeplinkDetails(deeplink);

		if (deeplinkDetails.getDeeplinkType() == DeeplinkType.PRODUCT_DETAIL_PAGE_LINK) {
			SearchHit<LinkConversionTable> searchHit = linkConversionTableSearchService.search(deeplinkDetails);
			deeplinkDetails.setWebUrlConversionTable(searchHit != null ? searchHit.getContent() : null);
		}

		WebUrlGenerator webUrlGenerator = WebUrlFactory.getDeeplinkGenerator(deeplinkDetails);
		String webUrl = webUrlGenerator.generate();

		return new ConversionResult(webUrl);
	}

	private LinkConversionTable populateLinkConversionTable(String webUrl, String deeplink, WebUrlDetails webUrlDetails) {
		LinkConversionTable conversionTable = new LinkConversionTable();
		conversionTable.setWebUrl(webUrl);
		conversionTable.setDeeplink(deeplink);
		ProductDetails productDetails = new ProductDetails();
		productDetails.setProductName(webUrlDetails.getProductName());
		productDetails.setBrandOrCategoryName(webUrlDetails.getBrandOrCategoryName());
		productDetails.setContentId(webUrlDetails.getContentId());
		if (webUrlDetails.getQueryParams() != null) {
			productDetails.setBoutiqueId(webUrlDetails.getQueryParams().get(LinkConversionConstants.WEB_URL_BOUTIQUE_ID_PARAM));
			productDetails.setMerchantId(webUrlDetails.getQueryParams().get(LinkConversionConstants.WEB_URL_MERCHANT_ID_PARAM));
		}
		conversionTable.setProductDetails(productDetails);
		return conversionTable;
	}

	private WebUrlDetails getWebUrlDetails(String webUrl) {
		return WebUrlParser.parse(webUrl);
	}

	private DeeplinkDetails getDeeplinkDetails(String deeplink) {
		return DeeplinkParser.parse(deeplink);
	}
}
