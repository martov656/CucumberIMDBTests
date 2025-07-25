package UiTests.Runners;


import io.cucumber.core.options.Constants;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("Features/IMDB")
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME,value = "UiTests.Steps.IMDB")
@ConfigurationParameter(key = Constants.FILTER_TAGS_PROPERTY_NAME,value = "@multiple")
@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME,value = "false")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME,value = "pretty, html:target/cucumber-report/cucumber.html")
public class TestRunner {
}