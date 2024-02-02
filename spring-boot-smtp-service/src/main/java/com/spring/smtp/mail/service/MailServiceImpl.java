package com.spring.smtp.mail.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.spring.smtp.mail.model.EmailEntity;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MailServiceImpl implements MailService {

	@Autowired
	MailHelper mailHelper;

	@Autowired
	private JavaMailSender javaMailSender;

	public String sendEmail(String to, String subject, String body) {
		SimpleMailMessage smail = new SimpleMailMessage();
		smail.setTo(to);
		smail.setSubject(subject);
		smail.setText(body);
		javaMailSender.send(smail);
		return "Mail Sent Successfully";

	}

	public String sendEmailWithThymeleafTemplate(String to, String subject, String body) {
		String updatedSubject = mailHelper.formatSubject(subject, LocalDate.now().toString());
		String emailText = mailHelper.getEmailTextWithTemplate("MyFirstEmailTemplate.html", LocalDate.now());
		MimeMessage mimeMessage = null;
		try {
			mimeMessage = createMimeMessage(updatedSubject, emailText, "msathyakumar9@gmail.com", to);
		} catch (MessagingException e) {
			log.info("Email error " + e.getMessage());
		}
		sendEmailWithMimeMessage(mimeMessage);
		return "Mail Sent Successfully";
	}

	@Override
	public String sendEmailWithThymeleafTemplate(EmailEntity emailEntity) {

		String updatedSubject = mailHelper.formatSubject(emailEntity.getEmailSubject(), LocalDate.now().toString());
		String emailText = mailHelper.getEmailTextWithTemplate("MyFirstEmailTemplate.html", emailEntity.getEmailBody());
		MimeMessage mimeMessage = null;
		try {
			mimeMessage = createMimeMessage(updatedSubject, emailText, emailEntity.getEmailFrom(),
					emailEntity.getEmailTo());
		} catch (MessagingException e) {
			log.info("Email error " + e.getMessage());
		}
		sendEmailWithMimeMessage(mimeMessage);
		return "Mail Sent Successfully";
	}

	public void sendEmailWithMimeMessage(MimeMessage mimeMessage) {
		javaMailSender.send(mimeMessage);
		log.info("Email Send Successfully");

	}

	public MimeMessage createMimeMessage(String emailSubject, String emailBodyText, String from, String to)
			throws MessagingException {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		helper.setSubject(emailSubject);
		helper.setText(emailBodyText, true);
		helper.setFrom(from);
		helper.setTo(to);
		return mimeMessage;

	}
}
