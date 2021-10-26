package com.louis.icemango.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.louis.icemango.admin"})
public class IceMangoAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(IceMangoAdminApplication.class, args);
    }

}
