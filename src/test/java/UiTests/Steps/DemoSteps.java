package UiTests.Steps;

import io.cucumber.java.en.When;

public class DemoSteps {

    @When("User opens browser")
    public void userOpensBrowser() {
        System.out.println("Blank page opens ...");
    }
}
