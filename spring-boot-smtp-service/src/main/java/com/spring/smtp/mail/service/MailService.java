package com.spring.smtp.mail.service;

import com.spring.smtp.mail.model.EmailEntity;

public interface MailService {

	public String sendEmail(String to, String subject, String body);

	public String sendEmailWithThymeleafTemplate(String to, String subject, String body);

	public String sendEmailWithThymeleafTemplate(EmailEntity emailEntity);

}
