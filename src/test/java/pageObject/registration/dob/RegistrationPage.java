package pageObject.registration.dob;

import baseDriver.PageDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Common;

public class RegistrationPage extends Common {
    public RegistrationPage() {
        PageFactory.initElements(PageDriver.getCurrentDriver(), this);

    }

    @FindBy(xpath = "//a[contains(text(),'জন্ম নিবন্ধন সার্টিফিকেট')]")
    public WebElement registerButtondob;
    @FindBy(id = "birth_reg_no")
    public WebElement dobno;
    @FindBy(css = "select[name='dob_day']")
    public WebElement days;
    @FindBy(css = "select[name='dob_month']")
    public WebElement months;
    @FindBy(css = "select[name='dob_year']")
    public WebElement years;
    @FindBy(id = "verify")
    public WebElement submitButton;
    @FindBy(xpath = "//div[contains(text(),'দুঃখিত.. যাচাই হয়নি! জন্ম সনদ নম্বর ও জন্ম তারিখ  সঠিক দিন..')]")
    public WebElement errorText;
    public String wrongText = "দুঃখিত.. যাচাই হয়নি! জন্ম সনদ নম্বর ও জন্ম তারিখ সঠিক দিন..";

    @Step("Button for registration by dob")
    public void ClickToRegisterbydobButton() {
        registerButtondob.click();
    }

    @Step("All the inputs for dob")
    public Boolean RegistrationbyData(String DobNo, String Day, int Month, int Year) {
        sendText(dobno, DobNo);
        selectitem(days, Day);
        selectitembynumber(months, Month);
        selectitembynumber(years, Year);
        return false;
    }

    public void submitButton() {
        submitButton.click();
    }


}