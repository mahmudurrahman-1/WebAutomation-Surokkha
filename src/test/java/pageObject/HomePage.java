package pageObject;

import baseDriver.PageDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Common;

public class HomePage extends Common {
    public HomePage() {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);
    }

    @FindBy(css = "a[class='su-h-reg-card']")
    public WebElement registerButton;

    public void ClickToRegister() {
        registerButton.click();
    }
}
