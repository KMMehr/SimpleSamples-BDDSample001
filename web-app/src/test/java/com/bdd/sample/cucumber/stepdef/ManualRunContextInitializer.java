package com.bdd.sample.cucumber.stepdef;

import com.bdd.sample.BDDIntegrationATTSampleProjectApplication;
import com.bdd.sample.cucumber.runner.BDDCucumberSpringBaseTestStarter;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = BDDIntegrationATTSampleProjectApplication.class)
@CucumberContextConfiguration
public class ManualRunContextInitializer extends BDDCucumberSpringBaseTestStarter {
}
