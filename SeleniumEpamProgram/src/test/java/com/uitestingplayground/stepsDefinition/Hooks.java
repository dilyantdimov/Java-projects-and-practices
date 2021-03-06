package com.uitestingplayground.stepsDefinition;

import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class Hooks {


    public Hooks(TestContext context) {
    }

    @Before
    public void BeforeSteps() {
    }

    @After
    public void AfterSteps(Scenario scenario) {
            if (scenario.isFailed()) {
                File screenCapture = ((TakesScreenshot) WebDriverManager.getDriver() ).getScreenshotAs(OutputType.FILE);
                String FilePath = System.getProperty("user.dir");
                try{
                    FileHandler.copy(screenCapture, new File(FilePath+"/target/logs/screenshots/test.png"));
                }catch (IOException e){
                    System.out.println("Failed to save screenshot: " + e.getLocalizedMessage());
                }
            }
//        testContext.getWebDriverManager().closeDriver();
    }
}
