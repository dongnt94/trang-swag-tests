package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Overview {

    WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'FINISH')]")
    private WebElement finish;

    public Overview(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void finish() {
        finish.click();
    }

}
