package com.spring.smtp.mail.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailEntity {

	private String emailTo;
	private String emailFrom;
	private String emailSubject;
	private String emailBody;

}
