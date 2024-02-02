package com.spring.smtp.mail.service;

import java.text.MessageFormat;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MailHelper {

	@Autowired
	private TemplateEngine templateEngine;

	public String formatSubject(String subject, String value) {
		return MessageFormat.format(subject, value);
	}

	public String getEmailTextWithTemplate(String templateName, LocalDate date) {
		var time = System.currentTimeMillis();
		Context context = new Context();
		context.setVariable("cur_date", date);
		String emailText = templateEngine.process(templateName, context);
		log.info("Processing template engine ", (System.currentTimeMillis() - time));
		return emailText;
	}
	
	public String getEmailTextWithTemplate(String templateName, String body) {
		var time = System.currentTimeMillis();
		Context context = new Context();
		context.setVariable("cur_date", body);
		String emailText = templateEngine.process(templateName, context);
		log.info("Processing template engine ", (System.currentTimeMillis() - time));
		return emailText;
	}

}
