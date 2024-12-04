package com.safetrust.hooks;

import com.safetrust.common.BaseTest;
import com.safetrust.keywords.WebUI;
import io.cucumber.java.*;

public class CucumberHooks {

    @BeforeAll
    public static void beforeAll(){
        System.out.println("================ beforeAll ===============");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("================ afterAll ===============");
    }

    @Before
    public void beforeScenario(){
        System.out.println("================ beforeScenario ===============");
    }

    @After
    public void afterScenario(){
        System.out.println("================ afterScenario ===============");
        WebUI.sleep(3);
        BaseTest.closeDriver();
    }

    @BeforeStep
    public void beforeStep(Scenario scenario) {
        System.out.println("================ beforeStep ===============");
    }

    @AfterStep
    public void afterStep(Scenario scenario){
        System.out.println("================ afterStep ===============");
    }
}
