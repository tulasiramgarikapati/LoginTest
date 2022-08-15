package test;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"C:\\Users\\tulas\\eclipse-workspace\\LoginTest\\src\\test\\resources\\fileresources\\logintest.feature"},
monochrome=true,
glue= {"classpath:test"},
publish=true,
plugin= {"pretty","html:C:\\Users\\tulas\\eclipse-workspace\\LoginTest\\logintest.html"})
public class TestRunner 
{
	
}
