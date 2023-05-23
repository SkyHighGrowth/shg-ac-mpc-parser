package com.brandmaker.skyhigh.ac.mpcparser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.brandmaker.skyhigh.ac.mpcparser", "com.shg.bmapi"}, exclude = SecurityAutoConfiguration.class)
public class AcMpcParserApplication {



    public static void main(String[] args) {
        SpringApplication.run(AcMpcParserApplication.class, args);
    }


}
