package elementos;

import org.openqa.selenium.WebDriver;

public class DemoSimpleSearchPage {

    private WebDriver driver;
    private final String url = "https://marcelodebittencourt.com/demopages/demosimplesearch/";

    public DemoSimpleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
