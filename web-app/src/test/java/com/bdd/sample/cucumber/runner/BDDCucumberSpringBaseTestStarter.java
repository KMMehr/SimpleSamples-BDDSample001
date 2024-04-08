package com.bdd.sample.cucumber.runner;

import com.bdd.sample.BDDIntegrationATTSampleProjectApplication;
import com.bdd.sample.cucumber.config.BDDAuthConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.bdd.sample.cucumber.apiinvoke.BDDAuthorizedInvoke;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;


//@CucumberOptions(features = {"D:/SampleProjects/BDD/com/BDDIntegrationSampleProjectThirdPhase/web-app/src/test/java/com/bdd/sample/cucumber/feature"}
@CucumberOptions(features = {"src/test/java/com/bdd/sample/cucumber/feature"}
        ,plugin = {"pretty", "json:target/cucumber-reports/cucumber.json"}
        ,glue = {  "com.bdd.sample.cucumber.stepdef",  "com.bdd.sample.cucumber.config" })
@ContextConfiguration(classes = BDDIntegrationATTSampleProjectApplication.class)
@RunWith(Cucumber.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = { ObjectMapper.class,  MockMvc.class ,
        BDDAuthConfiguration.class ,
        //ResourceOwnerPasswordResourceDetails.class ,
        BDDAuthorizedInvoke.class   })
public class BDDCucumberSpringBaseTestStarter {
}
