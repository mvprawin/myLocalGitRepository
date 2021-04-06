package com.qa.test;



import org.junit.runner.RunWith;

import cucumber.api.*;
import cucumber.api.junit.Cucumber;




@RunWith(Cucumber.class)
@CucumberOptions(
	    features="src/test/resources/Features",
	    glue="stepDefinitions",
	   // plugin= {"pretty","html:target/site/cucumber-report-html","json:target/cucumber-report.json"},
	   plugin= {"pretty","html:target/cucumber","json:target/cucumber.json",
			   "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/extent-reports/report.html"},
	    monochrome=true
	    )


public class TestRunner {

}

