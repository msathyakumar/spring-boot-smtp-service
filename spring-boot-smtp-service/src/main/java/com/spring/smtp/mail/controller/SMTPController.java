package com.spring.smtp.mail.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.smtp.mail.model.EmailEntity;
import com.spring.smtp.mail.service.MailService;

@RestController
public class SMTPController {

	@Autowired
	MailService mailService;

	@PostMapping("/test")
	public String testEmail() {
		return "success";
	}

	@PostMapping("/send/{to}/{subject}/{body}")
	public String sendEmail(@PathVariable("to") String to, @PathVariable("subject") String subject,
			@PathVariable("body") String body) {
		return mailService.sendEmail(to, subject, body);
	}
	
	@PostMapping("/send/v1/{to}/{subject}/{body}")
	public String sendEmail1(@PathVariable("to") String to, @PathVariable("subject") String subject,
			@PathVariable("body") String body) {
		return mailService.sendEmailWithThymeleafTemplate(to, subject, body);
	}
	
	
	@PostMapping("/send/v2/smtp")
	public String sendEmail1(@RequestBody EmailEntity emailEntity) {
		return mailService.sendEmailWithThymeleafTemplate(emailEntity);
	}
	
	
	

}
