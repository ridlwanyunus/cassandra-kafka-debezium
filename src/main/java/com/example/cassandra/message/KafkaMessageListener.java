package com.example.cassandra.message;

import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.cassandra.dto.InformationDto;
import com.example.cassandra.dto.Payload;
import com.example.cassandra.entity.Information;
import com.example.cassandra.service.InformationService;



@Component
public class KafkaMessageListener {
	
	
	@Value("${app.name}")
	private String appName;
	
	@Autowired
	private InformationService infoService;
	
	@Autowired
	private ExecutorService executorService;

	@KafkaListener(
		topics="mysql-connector-debezium.cdc.information",
		groupId = "mysql-connector-debezium",
		containerFactory = "containerFactory"
	)
	public void listener(Payload payload) {
		
		executorService.submit(() -> {
			
			String threadName = Thread.currentThread().getName();
			
			InformationDto informationDto = payload.getAfter();
			Information information = new Information();
			information.setId(informationDto.getId());
			information.setNpwp(informationDto.getNpwp());
			information.setSerialNumber(informationDto.getSerial_number());
			information.setCertificate(informationDto.getCertificate());
			information.setCreationDate(informationDto.getCreation_date());
			infoService.save(information);
						
			System.out.println(String.format("[%s] Serial Number id: %s Thread %s", appName, payload.getAfter().getId(), threadName));
			
		});
		
		
		
	}
	
	
}
