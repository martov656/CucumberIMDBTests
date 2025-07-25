package UiTests.Steps.IMDB;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IMDBActors {

    private WebDriver driver;
    private WebDriverWait wait;

    public void acceptCookiesIfVisible() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement acceptCookies = shortWait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Accept') or contains(text(),'Souhlasím') or contains(text(),'Rozumím')]")
            ));
            acceptCookies.click();
            System.out.println("Cookies byly akceptovány.");
        } catch (TimeoutException e) {
            System.out.println("Cookies banner se nezobrazil nebo už byl potvrzen.");
        }
    }

    @Given("user open imdb and put keyword")
    public void openHomeOfIMDbPutKeyword() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.imdb.com/");

        acceptCookiesIfVisible();
    }

    @When("the user enters {string} into the search field and presses Enter")
    public void enterSearchKeyword(String name) {
        WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
        searchBox.clear();
        searchBox.sendKeys(name);
        searchBox.sendKeys(Keys.ENTER); // simuluje Enter
    }

    @Then("the user should see a link to {string}")
    public void userShouldSeeLink(String name) {
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(., '" + name + "')]")
        ));
        Assertions.assertTrue(result.isDisplayed(), "Result link for " + name + " was not displayed.");
    }

    @Then("the page should contain {string}")
    public void pageShouldContain(String name) {
        Assertions.assertTrue(driver.getPageSource().contains(name), "Text '" + name + "' not found on page.");
    }


    @And("imdb browser is over")
    public void BrowserStackOver() {
        if (driver != null) {
            driver.quit();
        }
    }
}

