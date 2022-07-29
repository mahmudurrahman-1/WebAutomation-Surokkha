package testCase.registrationbydob;

import baseDriver.MainDriver;
import dataSet.SQL;
import io.qameta.allure.Step;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObject.HomePage;
import pageObject.registration.dob.RegistrationPage;
import utilitiesPackage.ScreenShots;

public class TCRegistration extends MainDriver {
    @Test(description = "Registration by Date of birth", dataProvider = "dobdata", dataProviderClass = SQL.class)
    public void registrationbyDob(String dobNo, String day, int month, int year) throws InterruptedException {
        /***************
         * All the Instance of classes*
         */
        HomePage home = new HomePage();
        RegistrationPage register = new RegistrationPage();
        SoftAssert softly = new SoftAssert();

        /***************
         * All the methods of classes
         */
        // Navigating to registration page
        home.ClickToRegister();
        //waiting for registration page loading
        register.waitForPageLoad();
        // Click to get Registration by dob module
        register.ClickToRegisterbydobButton();
        //Taking ScreenShot
        ScreenShots.screenshotForAllure("Registration for DOB Module");
        softly.assertFalse(register.RegistrationbyData(dobNo, day, month, year));
        Thread.sleep(10000);
        register.submitButton();
        ScreenShots.screenshotForAllure("Registration for DOB Module");
        softly.assertEquals(register.errorText, register.wrongText);
    }
}
