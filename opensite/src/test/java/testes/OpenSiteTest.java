package testes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import elementos.DemoSimpleSearchPage;

public class OpenSiteTest {

    private WebDriver driver;
    private DemoSimpleSearchPage demoPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        demoPage = new DemoSimpleSearchPage(driver);
    }

    @Test
    public void testPageTitle() throws InterruptedException {
        demoPage.open();
        Thread.sleep(3000);
        String expectedTitle = "Demo Simple Search using JavaScript";
        Assert.assertEquals(demoPage.getTitle(), expectedTitle, "Titulo da página difere do esperado");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
