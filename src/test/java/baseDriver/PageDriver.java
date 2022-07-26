package baseDriver;

import org.openqa.selenium.WebDriver;

public class PageDriver {
    private static final ThreadLocal<WebDriver> webdriver = new ThreadLocal<WebDriver>();
    private static PageDriver Obj = null;

    //Private constructor is defined for other classes can't get access to it directly
    private PageDriver() {
        //empty and generated by default
    }

    public static PageDriver Object() {
        if (Obj == null) {
            //creating instance of the class
            Obj = new PageDriver();

        }
        return Obj;
    }

    /*********
     * Encapsulation********
     */
    //Here Using SetDriver Method We are actually setting current web Driver
    public void SetDriver(WebDriver driver) {
        //Inside ThreadLocal WebDriver
        webdriver.set(driver);
    }

    //Using Get Method to get current driver
    public WebDriver Get() {
        //getting from ThreadLocal webdriver
        return webdriver.get();
    }

    //To access from instance of the class will be used everywhere
    public static WebDriver getCurrentDriver() {
        return Object().Get();
    }
}
