package com.bohui.wf.gps.website.webpage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class WebPageApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebPageApplication.class, args);
    }

}
