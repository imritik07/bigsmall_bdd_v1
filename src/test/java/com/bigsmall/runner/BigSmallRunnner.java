package com.bigsmall.runner;

//import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "features",
//		dryRun= true,
		glue = "com.bigsmall.stepDefinitions", monochrome = true)
public class BigSmallRunnner extends AbstractTestNGCucumberTests {
}
