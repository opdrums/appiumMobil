package runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;
import utils.readDate.BeforeSuite;
import utils.readDate.DateToFeature;
import utils.reporting.Report;

import java.io.IOException;

@RunWith(RunnerPersonality.class)


@CucumberOptions(
        features = "src/test/resources/features"
        ,glue = "definitions"
        ,tags = "@buy"
        ,monochrome = true
        ,snippets = SnippetType.CAMELCASE
)

public class MainRunners {
    @BeforeSuite
    public static void test() throws InvalidFormatException, IOException {
        Report.initReport();
        DateToFeature.overrideFeatureFiles("./src/test/resources/features");
    }
}
