package com.trendyol.lc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.trendyol.lc.data.repo")
public class ElasticsearchConfig {

}
