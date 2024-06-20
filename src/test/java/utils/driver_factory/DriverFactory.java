package utils.driver_factory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class DriverFactory {
    static AppiumDriver<MobileElement> driver;

    public static void setDriver(AppiumDriver<MobileElement> driver) {
        DriverFactory.driver = driver;
    }

    public static AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
