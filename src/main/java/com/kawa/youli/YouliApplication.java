package com.kawa.youli;

import com.kawa.youli.config.JdbcTemplateConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Import(JdbcTemplateConfiguration.class)
@SpringBootApplication
public class YouliApplication {

    public static void main(String[] args) {
        SpringApplication.run(YouliApplication.class, args);
    }

}
