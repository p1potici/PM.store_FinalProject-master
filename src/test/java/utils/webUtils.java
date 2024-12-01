package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class webUtils {

    public static WebDriver getWebDriver() {
        // Set up WebDriverManager for ChromeDriver
        WebDriverManager.chromedriver().setup();
        // Create and configure ChromeDriver instance
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;
    }
}
