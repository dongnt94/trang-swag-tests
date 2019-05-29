package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    WebDriver driver;

    @FindBy(xpath = "(//button[contains(text(),'ADD TO CART')])[1]")
    private WebElement addItem;
    @FindBy(xpath = "//span[@class='fa-layers-counter shopping_cart_badge']")
    private WebElement bag;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addItem() {
        addItem.click();
    }

    public void goToBag() throws InterruptedException {
        bag.click();
    }

}
