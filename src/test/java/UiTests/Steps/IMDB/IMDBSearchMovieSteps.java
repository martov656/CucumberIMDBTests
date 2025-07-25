package UiTests.Steps.IMDB;

import io.cucumber.datatable.DataTable;
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


public class IMDBSearchMovieSteps {

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

    @Given("user opens movie database home page")
    public void openMovieDatabaseHomepage() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.imdb.com/");

        acceptCookiesIfVisible();
    }

    @When("user is searching for the following movies:")
    public void userSearchesForMovies(DataTable dataTable) {
        List<String> movies = dataTable.asList();

        for (String movie : movies) {
            System.out.println("Searching for: " + movie);

            WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
            searchBox.clear();
            searchBox.sendKeys(movie);
            searchBox.sendKeys(Keys.ENTER);

            List<WebElement> results = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.xpath("//section[@data-testid='find-results-section-title']//a[contains(@href, '/title/')]")
            ));

            boolean found = false;
            for (WebElement result : results) {
                if (result.getText().toLowerCase().contains(movie.toLowerCase())) {
                    Assertions.assertTrue(result.isDisplayed(), "Result not found for: " + movie);
                    result.click();
                    found = true;
                    break;
                }
            }

            if (!found) {
                throw new RuntimeException("No suitable movie result found for: " + movie);
            }

            wait.until(ExpectedConditions.titleContains(movie));
            Assertions.assertTrue(driver.getPageSource().contains(movie), "Name not found on page: " + movie);

            clickTrailerLink();
            driver.get("https://www.imdb.com/");
        }
    }



    public void clickTrailerLink() {
        WebElement trailerLink = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("a.ipc-lockup-overlay[aria-label^='Watch']")
        ));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", trailerLink);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", trailerLink);


    }

    @Then("imdb browser is closed")
    public void closeImdbBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
