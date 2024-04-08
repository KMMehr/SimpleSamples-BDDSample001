package com.bdd.sample.cucumber.config;

import com.bdd.sample.BDDIntegrationATTSampleProjectApplication;
import com.bdd.sample.cucumber.apiinvoke.BDDAuthorizedInvoke;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

//import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

@ContextConfiguration(classes = BDDIntegrationATTSampleProjectApplication.class)
//@CucumberContextConfiguration
@SpringBootTest(classes = { ObjectMapper.class,  MockMvc.class ,
        BDDAuthConfiguration.class ,
        //ResourceOwnerPasswordResourceDetails.class ,
        BDDAuthorizedInvoke.class   })
public class BDDCucumberConfig {
}
