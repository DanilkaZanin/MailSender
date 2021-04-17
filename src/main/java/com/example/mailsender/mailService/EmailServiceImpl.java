package com.example.mailsender.mailService;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl {
    private final JavaMailSender emailSender;
    public EmailServiceImpl(JavaMailSender emailSender){
        this.emailSender = emailSender;
    }


    public void sendSimpleMessage(
            String to, String subject, String text) {

        SimpleMailMessage message = new SimpleMailMessage();
        /*message.setFrom("noreply@baeldung.com");*/
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);

    }
}