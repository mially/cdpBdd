package com.epam.cdpBdd.core.webdriver.factory;

import com.epam.cdpBdd.utils.WebDriverDecorator;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ChromeDriverSingleton {
    private static WebDriver driver;

    private ChromeDriverSingleton() {}

    public static WebDriver getDecoratedWebDriverInstance() {
        if (null == driver) {
            ChromeDriverManager.getInstance().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver = new WebDriverDecorator(driver);
        }
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
