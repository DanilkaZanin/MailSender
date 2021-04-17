package com.example.mailsender.mailService;


import com.example.mailsender.config.Configuration;
import com.example.mailsender.csvParser.CsvParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;


@SpringBootApplication
public class EmailService {
    final static Logger logger = Logger.getLogger(EmailService.class.getName());
    public static void main(String[] args) throws Exception{
        ConfigurableApplicationContext context = SpringApplication.run(EmailService.class, args);
        logger.info("Program has been started");

        String[] allMails = CsvParser.readColumn("mails");
        String[] allNames = CsvParser.readColumn("names");

        for(int i = Configuration.a; i < allMails.length; i++){
            String oneMail = allMails[i];
            String oneName = allNames[i];
            context.getBean(EmailServiceImpl.class).sendSimpleMessage(oneMail,Configuration.subject,Configuration.message);
            logger.info( "message has been sent to: "+ oneName);
            TimeUnit.MINUTES.sleep(Configuration.timeSleep);
        }
        logger.info("The program has been ended");
    }
}
