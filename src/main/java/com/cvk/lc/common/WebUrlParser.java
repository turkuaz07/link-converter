package com.cvk.lc.common;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.ObjectUtils;

import com.cvk.lc.model.WebUrlDetails;
import com.cvk.lc.type.WebUrlType;

public class WebUrlParser {

	private WebUrlParser() {
		super();
	}

	public static WebUrlDetails parse(String urlAddress) {
		WebUrlDetails urlDetails = new WebUrlDetails();
		WebUrlType urlType = WebUrlTypeDeterminer.determine(urlAddress);
		urlDetails.setUrlType(urlType);

		URL url = getURL(urlAddress);
		if (url != null) {

			if (urlType == WebUrlType.PRODUCT_DETAIL_PAGE_URL) {
				String path = url.getPath();
				String[] pathVariables = path.substring(1).split("/");

				urlDetails.setBrandOrCategoryName(pathVariables[0]);
				String[] productAndContentId = pathVariables[1].split("-p-");
				urlDetails.setProductName(productAndContentId[0]);
				urlDetails.setContentId(productAndContentId[1]);
			}

			if (!ObjectUtils.isEmpty(url.getQuery())) {
				urlDetails.setRawQuery(url.getQuery());
				String[] queryKeyValues = url.getQuery().split("&");
				Map<String, String> queryParams = new HashMap<>();
				for (int i = 0; i < queryKeyValues.length; i++) {
					String[] keyValue = queryKeyValues[i].split("=");
					queryParams.put(keyValue[0], keyValue[1]);
				}
				urlDetails.setQueryParams(queryParams);
			}
		}

		return urlDetails;
	}

	private static URL getURL(String urlAddress) {
		URL url = null;
		try {
			url = new URL(urlAddress);
		} catch (MalformedURLException e) {
			// urlAddress will be valid so far, thats why no need to argue :)
		}
		return url;
	}
}
