package com.mohamedelkhazen.sendingEmail;

import com.mohamedelkhazen.sendingEmail.emailClient.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SendingEmailApplication {

	@Autowired
	private EmailSenderService service;

	public static void main(String[] args) {
		SpringApplication.run(SendingEmailApplication.class, args);
	}
	@EventListener(ApplicationReadyEvent.class)
	public void triggerMail() {

		service.sendSimpleEmail("mohammed.elkhazen@gmail.com",
		"This is the Email body",
				"This is the email subject");
	}
}
