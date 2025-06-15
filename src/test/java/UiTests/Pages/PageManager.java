package UiTests.Pages;

import UiTests.Steps.TestContext;

public class PageManager {

    private final TestContext context;
    private BasePage basePage;

    public PageManager(TestContext context) {
        this.context = context;
    }

    public BasePage getBasePage() {
        return (basePage == null) ? new BasePage(context) : basePage;
    }

}
