package net.seamlessly.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                //"pretty",
               // "json:target/cucumber.json",
                "html:target/cucumber-report.html"
                //"rerun:target/rerun.txt",
               // "me.jvt.cucumber.report.PrettyReports:target/cucumber",
        },
        features = "src/test/resources/features",

        glue = "net/seamlessly/step_definitions",
        dryRun = false,
        tags = "@wip",
        publish = false

)
public class CukesRunner {
}
