package dataSet;

import io.qameta.allure.Step;
import org.testng.annotations.DataProvider;

public class SQL {
    @Step("Registration by NID Data")
    @DataProvider(name = "registrationdata")
    public static Object[][] registrationInfos() {
        Object[][] data = {{"1", "5164960577", "22", 11, 6}};
        return data;
    }

    @Step("Registration By DOB Data")
    @DataProvider(name = "dobdata")
    public static Object[][] registrationDOB() {
        Object[][] data = {{"105462895164960577", "29", 8, 2}};
        return data;
    }

    @Step("Registration by Passport Data")
    @DataProvider(name = "passportdata")
    public static Object[][] registrationPassport() {
        Object[][] data = {{"3", "AC0215425", "22", 11, 6}};
        return data;
    }
    @DataProvider(name = "verifydata")
    public static Object[][] verifyInfos() {
        Object[][] data = {{"1", "5164960577", "22", 2, 6}};
        return data;
    }

}
