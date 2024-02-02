package com.spring.smtp.mail.schedular;

import java.time.LocalDateTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SpringBootCustomSchedular {
	
	//@Scheduled(fixedDelay = 5000)
	public void logMessage() {
		log.info("Run At 5 sec with Fixed delay Cur DT: "+LocalDateTime.now());
	}
	
	@Scheduled(cron = "0 0 0/1 * * *")
	public void logWithCron() {
		log.info("Run At 15 sec Using cron Cur DT: "+LocalDateTime.now());
	}

}
