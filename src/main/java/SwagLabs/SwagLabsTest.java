package SwagLabs;

import POM.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SwagLabsTest {

    private WebDriver driver;
    private String baseUrL;
    private WebDriverWait wait;
    private LoginPage login;
    private ProductPage productPage;
    private YourCart yourCart;
    private YourInformation yourInformation;
    private Overview overview;

    @Test(priority = 1)
    public void testLogin() throws Exception {
        login.setUserName("standard_user");
        login.setPassword("secret_sauce");
        login.login();
    }

    @Test(priority = 2)
    public void testPickItem() throws Exception {
        productPage.addItem();
        productPage.goToBag();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Your Cart')]")));
        yourCart.checkOut();
    }

    @Test(priority = 3)
    public void testCheckout() throws Exception {
        yourInformation.setFirstName("Test");
        yourInformation.setLastName("Test");
        yourInformation.setZipCode("70000");
        yourInformation.continues();
    }

    @Test(priority = 4)
    public void testOverview() throws Exception {
        overview.finish();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]")));
    }

    @BeforeClass
    public void beforeClass() {
        baseUrL = "https://www.saucedemo.com/";
        System.setProperty("webdriver.chrome.driver", "/Users/lubaby/Documents/Selenium/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        login = new LoginPage(driver);
        productPage = new ProductPage(driver);
        yourCart = new YourCart(driver);
        yourInformation = new YourInformation(driver);
        overview = new Overview(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(baseUrL);
    }

    @AfterClass
    public void afterTest() {
        driver.quit();
    }

}
