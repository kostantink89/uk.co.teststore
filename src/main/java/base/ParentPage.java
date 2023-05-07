package base;

import org.openqa.selenium.WebDriver;
import pages.CommonActionsWithElements;

public class ParentPage extends CommonActionsWithElements {

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }

    protected String base_URL = "http://teststore.automationtesting.co.uk/";

}
