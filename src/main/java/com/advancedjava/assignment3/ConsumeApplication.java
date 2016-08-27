package com.advancedjava.assignment3;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;
/**
 * Created by srathi on 8/9/16.
 */
@SpringBootApplication
public class ConsumeApplication implements CommandLineRunner{

        private static final Logger log = LoggerFactory.getLogger(ConsumeApplication.class);

        public static void main(String args[]) {
            SpringApplication.run(Application.class);
        }

        @Override
        public void run(String... args) throws Exception {
            RestTemplate restTemplate = new RestTemplate();
            Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
            log.info(quote.toString());
        }
    }
