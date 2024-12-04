package com.safetrust.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@CucumberOptions(
        features = "src/test/resources/features/Login/Login.feature",
        glue = {"com.safetrust.stepdefinitions",
                "com.safetrust.hooks",
                "com.safetrust.models"
        },
        plugin = {"pretty",
                "html:target/cucumber-reports/TestRunnerLogin.html",
                "json:target/cucumber-reports/TestRunnerLogin.json",
                "html:target/cucumber-html-report.html"},
        tags = "@SuccessfulLogin"
)

@Test
public class TestRunnerLogin extends AbstractTestNGCucumberTests{
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() { return  super.scenarios();}
}
