package testCase.registrationbypassport;

import baseDriver.MainDriver;
import dataSet.SQL;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pageObject.HomePage;
import pageObject.registration.passport.RegistrationPage;
import utilitiesPackage.ScreenShots;

public class TCPassport extends MainDriver {
    @Test(description = "Registration by Date of birth", dataProvider = "passportdata", dataProviderClass = SQL.class)
    public void registrationbyPassportdata(int select, String passportno, String day, int month, int year) throws InterruptedException {
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
        // Click to get Registration by passport module
        register.RegistationbyPassButton();
        //Taking ScreenShot
        ScreenShots.screenshotForAllure("Registration for passport Module");
        softly.assertFalse(register.RegistrationbyPassport (select,passportno, day, month, year));
        Thread.sleep(10000);
        register.submit();
        ScreenShots.screenshotForAllure("Registration for passport Module");
        softly.assertEquals(register.errorText, register.wrongText);
    }
}
