package com.trendyol.lc.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.trendyol.lc.data.document.LinkConversionLog;
import com.trendyol.lc.data.repo.LinkConversionLogRepository;

@Service
public class LinkConversionTxLogger {
	
	@Autowired
	private LinkConversionLogRepository linkConversionLogRepository;

	@Async
	public void log(LinkConversionLog conversionLog) {
		linkConversionLogRepository.save(conversionLog);
	}
}
