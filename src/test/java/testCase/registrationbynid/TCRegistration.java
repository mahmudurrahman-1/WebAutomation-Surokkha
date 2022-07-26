package testCase.registrationbynid;

import baseDriver.MainDriver;
import dataSet.SQL;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObject.HomePage;
import pageObject.registration.nid.RegistrationPage;
import utilitiesPackage.ScreenShots;

public class TCRegistration extends MainDriver {
    @Test(description = "This Part is Used for registration", dataProvider = "registrationdata", dataProviderClass = SQL.class)
    public void Registration(String category, String id, String day, int month, int year) throws InterruptedException {
        //All The Class Instances
        HomePage home = new HomePage();
        RegistrationPage registration = new RegistrationPage();
        SoftAssert softly = new SoftAssert();
        //All the action taken
        //Registration button
        home.ClickToRegister();
        registration.waitForPageLoad();
        registration.ClickRegButton();
        //Inputs
        softly.assertFalse(registration.StartRegistration(category, id, day, month, year));

        //Here Thread is used because of manually Entering Auto generated number
        Thread.sleep(10000);
        //After entering autogenerated number clicked for submitting
        registration.ClickSubmit();
        //If already registered a message will appeard then checking is it equal?
        softly.assertEquals(registration.alertTitle, registration.notregistredText);
        ScreenShots.screenshotForAllure("Registration");
    }

}
