package UiTests.Steps;

import UiTests.Pages.BasePage;
import UiTests.Pages.PageManager;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Properties;

public class Hooks {

    private final TestContext context;

    public Hooks(TestContext context) {
        this.context = context;
    }

    @Before()
    public void before() throws MalformedURLException {
        this.loadConfigFile();
        context.driver = new ChromeDriver();
        context.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        context.pm = new PageManager(context);
    }

    @After()
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            context.pm.getBasePage().takeScreenshot();
        }
        if (context.driver != null) {
            context.driver.quit();
        }
    }

    private void loadConfigFile() {
        Properties configProperties;
        try {
            InputStream input = new FileInputStream("src/test/java/UiTests/Configs/courseConfig.properties");
            configProperties = new Properties();
            configProperties.load(input);
        } catch (IOException ex) {
            throw new Error("Config file not loaded ...");
        }
        context.configProperties = configProperties;
    }

}
