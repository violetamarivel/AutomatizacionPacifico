package com.pacifico.test.runner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Listeners;

@Listeners(com.pacifico.test.listeners.TestNGListener.class)
@CucumberOptions(
        features = {"src/test/java/com/pacifico/test/features/"},
        glue = {"com/pacifico/test/steps"},
        format = {"json:target/cucumber.json", "html:target/site/cucumber-pretty"},
        tags = {"@Test"})
public class TestRunnerTest extends AbstractTestNGCucumberTests {


}
