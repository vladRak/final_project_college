package com.final_project_college.util.mail;

import com.sun.mail.smtp.SMTPTransport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Optional;
import java.util.Properties;

public class MailSender {

    private static final Logger logger = LoggerFactory.getLogger(MailSender.class);

    public Optional<String> sendMail(String recipient, String subject, String text) {

        Optional<String> serverResponse = Optional.empty();

        Properties props = System.getProperties();
        props.put("mail.smtps.host", "smtp.gmail.com");
        props.put("mail.smtps.auth", "true");

        Session session = Session.getInstance(props, null);
        Message msg = new MimeMessage(session);

        try {
            msg.setFrom(new InternetAddress("mail@gmail.com"));
            msg.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(recipient, false));
            msg.setSubject(subject + System.currentTimeMillis());

            msg.setText(text);

            msg.setHeader("X-Mailer", "Tov Are's program");
            msg.setSentDate(new Date());
            SMTPTransport t =
                    (SMTPTransport) session.getTransport("smtps");
            t.connect("smtp.gmail.com", "admin@tovare.com", "<insert password here>");
            t.sendMessage(msg, msg.getAllRecipients());
            serverResponse = Optional.ofNullable(t.getLastServerResponse());
            t.close();

        } catch (MessagingException e) {
            e.printStackTrace();
            logger.error(e.getMessage());
        }

        return serverResponse;
    }
}