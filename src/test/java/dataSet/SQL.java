package dataSet;

import org.testng.annotations.DataProvider;

public class SQL {
    @DataProvider(name = "registrationdata")
    public static Object[][] registrationInfos() {
        Object[][] data = {{"1", "5164960577", "22", 11, 6}};
        return data;
    }

    @DataProvider(name = "verifydata")
    public static Object[][] verifyInfos() {
        Object[][] data = {{"1", "5164960577", "22", 2, 6}};
        return data;
    }

}
