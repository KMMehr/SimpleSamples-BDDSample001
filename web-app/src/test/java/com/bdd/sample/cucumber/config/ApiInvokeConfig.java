package com.bdd.sample.cucumber.config;


import com.bdd.sample.cucumber.apiinvoke.Sample001ApiInvoke;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiInvokeConfig {

    @Bean
    public Sample001ApiInvoke createSample001ApiInvoke()
    {
        return new Sample001ApiInvoke();
    }

}
