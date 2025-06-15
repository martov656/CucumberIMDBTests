package UiTests.Steps;

import io.cucumber.java.en.When;

public class DemoSteps {

    private final TestContext context;

    public DemoSteps(TestContext context) {
        this.context = context;
    }


    @When("User opens browser")
    public void userOpensBrowser() {
        context.pm.getDemoPage().openBrowser();
    }
}
