package com.trendyol.lc.data.repo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.trendyol.lc.data.document.LinkConversionLog;

@Repository
public interface LinkConversionLogRepository extends ElasticsearchRepository<LinkConversionLog, String> {

}
