package UiTests.Pages;

import UiTests.Steps.TestContext;
import org.apache.maven.surefire.shared.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Random;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected TestContext context;

    public BasePage(TestContext context) {
        this.context = context;
        this.driver = context.driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
    }

    public void showOnSecondScreen() {
        if (context.configProperties.getProperty("showOnSecondScreen").equals("true")) {
            Point point = new Point(-2000, 0);
            driver.manage().window().setPosition(point);
        }
    }

    protected void clickWebElement(WebElement element) {
        try {
            clickWebElementWithAction(element);
        } catch (WebDriverException e) {
            throw new Error("Element click failed ...");
        }
    }

    private void clickWebElementWithAction(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(element))).build().perform();
        element.click();
    }

    protected void sendKeysToWebElement(WebElement element, String text) {
        try {
            sendKeysToWebElementWithAction(element, text);
        } catch (WebDriverException e) {
            throw new Error("SendKeys to element failed ...");
        }
    }

    private void sendKeysToWebElementWithAction(WebElement element, String text) {
        Actions action = new Actions(driver);
        action.moveToElement(wait.until(ExpectedConditions.elementToBeClickable(element))).build().perform();
        element.sendKeys(text);
    }


    public int getRandomNumber() {
        Random rand = new Random();
        int r = rand.nextInt(1000000);
        return r;
    }


    protected void ThreadSleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ;
    }

    public void takeScreenshot() {
        String screenshotDir = System.getProperty("user.dir") + File.separator + "screenshots";
        File directory = new File(screenshotDir);
        if (!directory.exists()) {
            directory.mkdir();
        }
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // System.out.println(System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + "screenshot_" + timeStamp + ".png");
        try {
            FileUtils.copyFile(scrFile, new File(screenshotDir + File.separator + "screenshot_" + timeStamp + ".png"), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
