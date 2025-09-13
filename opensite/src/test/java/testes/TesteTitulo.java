package testes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import elementos.ElementoLogin;

public class TesteTitulo {

    private WebDriver driver;
    private ElementoLogin demoPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        demoPage = new ElementoLogin(driver);
    }

    @Test
    public void testPageTitle() throws InterruptedException {
        demoPage.open();
        Thread.sleep(3000);
        String expectedTitle = "Te Internet2";
        Assert.assertEquals(demoPage.getTitle(), expectedTitle, "Titulo da página difere do esperado");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
