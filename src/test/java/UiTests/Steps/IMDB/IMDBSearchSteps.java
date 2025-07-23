package UiTests.Steps.IMDB;

import io.cucumber.datatable.DataTable;
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
import java.util.List;


public class IMDBSearchSteps {

    private WebDriver driver;
    private WebDriverWait wait;

    @Given("the user opens the IMDb homepage")
    public void openIMDbHomepage() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.imdb.com/");
    }

    @When("the user searches for the following celebrities:")
    public void userSearchesForCelebrities(DataTable dataTable) {
        List<String> names = dataTable.asList();

        for (String name : names) {
            System.out.println("Searching for: " + name);

            // Vyhledání pole a zadání jména
            WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
            searchBox.clear();
            searchBox.sendKeys(name);
            searchBox.sendKeys(Keys.ENTER);

            // Počkej na výsledek a klikni na něj
            WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//a[contains(., '" + name + "')]")
            ));
            Assertions.assertTrue(result.isDisplayed(), "Result not found for: " + name);
            result.click();

            // Ověř, že stránka obsahuje jméno
            wait.until(ExpectedConditions.titleContains(name));
            Assertions.assertTrue(driver.getPageSource().contains(name), "Name not found on page: " + name);

            // Po kliknutí na herce můžeme zavolat pomocné metody (nebo přidat další kroky v Gherkinu)
            clickFirstKnownForMovie();
            clickTrailerLink();

            // Po skončení se vrať zpět na homepage pro další jméno
            driver.get("https://www.imdb.com/");
        }
    }

    public void clickFirstKnownForMovie() {
        WebElement firstKnownForMovie = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector(".ipc-primary-image-list-card__title")
        ));

        String movieTitle = firstKnownForMovie.getText().trim();
        System.out.println("První film v sekci 'Known For': " + movieTitle);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstKnownForMovie);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstKnownForMovie);
    }

    public void clickTrailerLink() {
        WebElement trailerLink = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("a.ipc-lockup-overlay[aria-label^='Watch']")
        ));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", trailerLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", trailerLink);
    }

    @Then("the browser is closed")
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
