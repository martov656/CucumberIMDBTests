package UiTests.Pages;

import UiTests.Steps.TestContext;
import org.openqa.selenium.support.PageFactory;

public class DemoPage extends BasePage{
    public DemoPage(TestContext context) {
        super(context);
        PageFactory.initElements(driver, this);
    }
}
