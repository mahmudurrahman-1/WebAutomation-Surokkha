package dataSet;

import org.testng.annotations.DataProvider;

public class SQL {
    @DataProvider(name = "registrationdata")
    public static Object[][] registrationInfos() {
        Object[][] data = {{"1", "5104961577", "29", 10, 6}};
        return data;
    }

    @DataProvider(name = "verifydata")
    public static Object[][] verifyInfos() {
        Object[][] data = {{"1", "5104961577", "28", "9", "1999"}};
        return data;
    }

}
