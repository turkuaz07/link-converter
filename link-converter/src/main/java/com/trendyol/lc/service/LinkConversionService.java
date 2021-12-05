package com.trendyol.lc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trendyol.lc.common.LinkConversionConstants;
import com.trendyol.lc.common.WebUrlParser;
import com.trendyol.lc.data.document.LinkConversionTable;
import com.trendyol.lc.data.repo.LinkConversionTableRepository;
import com.trendyol.lc.generator.deeplink.DeeplinkFactory;
import com.trendyol.lc.generator.deeplink.DeeplinkGenerator;
import com.trendyol.lc.model.ConversionResult;
import com.trendyol.lc.model.ProductDetails;
import com.trendyol.lc.model.WebUrlDetails;

@Service
public class LinkConversionService {

	@Autowired
	private LinkConversionTableRepository linkConversionTableRepository;

	public ConversionResult convertToDeeplink(String webUrl) {

		WebUrlDetails webUrlDetails = getWebUrlDetails(webUrl);

		DeeplinkGenerator deeplinkGenerator = DeeplinkFactory.getDeeplinkGenerator(webUrlDetails);
		String deeplink = deeplinkGenerator.generate();

		linkConversionTableRepository.save(populateLinkConversionTable(webUrl, deeplink, webUrlDetails));

		return new ConversionResult(deeplink);
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
}
