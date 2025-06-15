package UiTests.Pages;

import UiTests.Steps.TestContext;

public class PageManager {

    private final TestContext context;
    private BasePage basePage;
    private DemoPage demoPage;

    public PageManager(TestContext context) {
        this.context = context;
    }

    public BasePage getBasePage() {
        return (basePage == null) ? new BasePage(context) : basePage;
    }

    public DemoPage getDemoPage() {
        return (demoPage == null) ? new DemoPage(context) : demoPage;
    }
}
