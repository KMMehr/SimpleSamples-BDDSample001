package com.bdd.sample.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
//import org.springframework.security.oauth2.client.OAuth2RestTemplate;
//import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.test.context.TestPropertySource;

import java.util.Arrays;

@Configuration
@TestConfiguration
@TestPropertySource("classpath:micro-services-auth-info-test.properties")
@PropertySource("classpath:micro-services-auth-info-test.properties")
public class S2bddSampleAuthConfiguration {

    @Value("${BIZ.Services.bddSample.client-id}")
    private String bddSampleClientID;

    @Value("${BIZ.Services.bddSample.client-secret}")
    private String bddSampleSecret;

    @Value("${BIZ.Services.bddSample.access-token-uri}")
    private String bddSampleAccessTokenUri;

    @Value("${BIZ.Services.bddSample.s2s-user}")
    private String bddSampleS2SUser;

    @Value("${BIZ.Services.bddSample.s2s-password}")
    private String bddSampleS2SPassword;

}

