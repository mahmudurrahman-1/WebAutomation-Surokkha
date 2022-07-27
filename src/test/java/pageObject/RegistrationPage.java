package pageObject;

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

    @FindBy(xpath = "//a[contains(text(),'জাতীয় পরিচয়পত্র')]")
    public WebElement nIDButton;

    @FindBy(id = "basic_type")
    public WebElement peopleCategories;
    @FindBy(id = "nid")
    public WebElement nIDNo;
    @FindBy(css = "select[name='dob_day']")
    public WebElement days;
    @FindBy(css = "select[name='dob_month']")
    public WebElement months;
    @FindBy(css = "select[name='dob_year']")
    public WebElement years;
    @FindBy(id = "verify")
    public WebElement submitButton;
    @FindBy(xpath = "//div[contains(text(),'উক্ত জাতীয় পরিচয়পত্র দ্বারা পূর্বে নিবন্ধন করা হয়ে')]")
    public WebElement alertTitle;
    public String alreadyregistredText = "উক্ত জাতীয় পরিচয়পত্র দ্বারা পূর্বে নিবন্ধন করা হয়েছে!";

    @Step("Click to Registration button")
    public void ClickRegButton() {
        nIDButton.click();
    }

    @Step("All the inputs for registration")
    public void StartRegistration(String categories, String idno, String day, int month, int year) {
        selectitem(peopleCategories, categories);
        sendText(nIDNo, idno);
        selectitem(days, day);
        selectitembynumber(months, month);
        selectitembynumber(years, year);
    }

    @Step("Submit button")
    public void ClickSubmit() {
        submitButton.click();

    }


}
