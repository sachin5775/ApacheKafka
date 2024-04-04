package com.zomatoboy.zomatoboy.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaServices {
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	private static final Logger log = LoggerFactory.getLogger(KafkaServices.class);

	public boolean updateLocation(String location) {
		this.kafkaTemplate.send(com.zomatoboy.zomatoboy.config.Appconstants.LOCATION_UPDATE_TOPIC, location);
		log.info("message hits");
		return true;
	}
}
