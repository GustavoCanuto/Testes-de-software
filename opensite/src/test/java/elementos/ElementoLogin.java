package elementos;

import org.openqa.selenium.WebDriver;

public class ElementoLogin {

    private WebDriver driver;
    private final String url = "https://the-internet.herokuapp.com/login";

    public ElementoLogin(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(url);
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
