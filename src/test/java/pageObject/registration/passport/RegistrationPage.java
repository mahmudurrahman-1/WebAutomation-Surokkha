package pageObject.registration.passport;

import baseDriver.PageDriver;
        import io.qameta.allure.Step;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.FindBy;
        import org.openqa.selenium.support.PageFactory;
        import utilities.Common;

public class RegistrationPage extends Common {
    public RegistrationPage(){
        PageFactory.initElements(PageDriver.getCurrentDriver(),this);
    }
    @FindBy(xpath = "//a[contains(text(),'পাসপোর্ট (বাংলাদেশি/বিদেশি)')]")
    public WebElement registrationbyPassportbutton;
    @FindBy(id="basic_type")
    public WebElement selectBy;
    @FindBy(id = "passport_no")
    public WebElement passportNo;
    @FindBy(css = "select[name='dob_day']")
    public WebElement days;
    @FindBy(css = "select[name='dob_month']")
    public WebElement months;
    @FindBy(css = "select[name='dob_year']")
    public WebElement years;
    @FindBy(id = "verify")
    public WebElement submitButton;
    @FindBy(xpath = "//div[contains(text(),'দুঃখিত.. যাচাই হয়নি! পাসপোর্ট নম্বর ও জন্ম তারিখ সঠিক দিন..')]")
    public WebElement errorText;
    public String wrongText = "দুঃখিত.. যাচাই হয়নি! পাসপোর্ট নম্বর ও জন্ম তারিখ সঠিক দিন..";

    @Step("Button For Registration module")
    public void RegistationbyPassButton(){
        registrationbyPassportbutton.click();
    }
    @Step("Registration By Passport data")
    public boolean RegistrationbyPassport(String Selection,String PassportNo, String day,int Month,int Year){
        selectitem(selectBy,Selection);
        sendText(passportNo,PassportNo);
        selectitem(days,day);
        selectitembynumber(months,Month);
        selectitembynumber(years,Year);
        return false;

    }
    @Step("Submit Button")
    public void submit(){
        submitButton.click();
    }

}
