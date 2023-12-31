package de.urlchecker.urlchecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UrlcheckerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UrlcheckerApplication.class, args);
    }

}
