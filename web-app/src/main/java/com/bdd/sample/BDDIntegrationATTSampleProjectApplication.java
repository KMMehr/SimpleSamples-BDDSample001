package com.bdd.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication(scanBasePackages = {
        "com.bdd.sample",
        "com.bdd.sample.domain.model",
        "com.bdd.sample.domain.service",
        })
@EntityScan(basePackages = {
        "com.bdd.sample.domain.model",
        "com.bdd.sample.facade",
        "com.bdd.sample.domain.service",
        "com.bdd.sample.proxy.*"
        })
public class BDDIntegrationATTSampleProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BDDIntegrationATTSampleProjectApplication.class, args);

    }

}