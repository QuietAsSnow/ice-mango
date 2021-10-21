package com.louis.icemango;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.louis.icemango"})
public class IceMangoApplication {

    public static void main(String[] args) {
        SpringApplication.run(IceMangoApplication.class, args);
    }

}
