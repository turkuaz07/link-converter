package com.cvk.lc.data.service;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.cvk.lc.data.document.LinkConversionTable;
import com.cvk.lc.model.DeeplinkDetails;

@Service
public class LinkConversionTableSearchService {

	@Autowired
	ElasticsearchOperations operations;

	public SearchHit<LinkConversionTable> search(DeeplinkDetails deeplinkDetails) {

		BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

		if (!ObjectUtils.isEmpty(deeplinkDetails.getContentId())) {
			boolQueryBuilder.must(QueryBuilders.matchQuery("productDetails.contentId", deeplinkDetails.getContentId()).operator(Operator.AND));
		}
		if (!ObjectUtils.isEmpty(deeplinkDetails.getCampaignId())) {
			boolQueryBuilder.must(QueryBuilders.matchQuery("productDetails.boutiqueId", deeplinkDetails.getCampaignId()).operator(Operator.AND));
		}
		if (!ObjectUtils.isEmpty(deeplinkDetails.getMerchantId())) {
			boolQueryBuilder.must(QueryBuilders.matchQuery("productDetails.merchantId", deeplinkDetails.getMerchantId()).operator(Operator.AND));
		}

		NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder().withFilter(boolQueryBuilder).build();

		return operations.searchOne(nativeSearchQuery, LinkConversionTable.class);
	}
}
