package com.example.mobileappwspractise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class MobileAppWsPractiseApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MobileAppWsPractiseApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MobileAppWsPractiseApplication.class, args);
    }

}
