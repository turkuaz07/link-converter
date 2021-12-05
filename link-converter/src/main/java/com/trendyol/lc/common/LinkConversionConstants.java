package com.trendyol.lc.common;

public class LinkConversionConstants {

	private LinkConversionConstants() {
		super();
	}
	
	public static final String GENERAL_URL_REGEX = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
	public static final String PRODUCT_DETAIL_PAGE_URL_REGEX = "-p-[0-9]+";
	public static final String SEARCH_PAGE_URL_REGEX = "/sr?";	
	
	public static final String PRODUCT_DETAIL_PAGE_DEEPLINK_INDICATOR = "Product&ContentId";
	public static final String SEARCH_PAGE_DEEPLINK_INDICATOR = "Search&Query";
	
	public static final String DEEPLINK_PREFIX = "ty://?Page=";
	public static final String WEB_URL_HOSTNAME = "https://www.trendyol.com";
	
	public static final String WEB_URL_BOUTIQUE_ID_PARAM = "boutiqueId";
	public static final String WEB_URL_MERCHANT_ID_PARAM = "merchantId";
	
	public static final String DEEPLINK_CAMPAIGN_ID_PARAM = "CampaignId";
	public static final String DEEPLINK_MERCHANT_ID_PARAM = "MerchantId";
}
