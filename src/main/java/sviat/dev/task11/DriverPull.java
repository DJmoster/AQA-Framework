package sviat.dev.task11;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverPull {
    private static WebDriver driver;
    private static WebDriverWait wait;

    private DriverPull() {}

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");

            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        return driver;
    }

    public static WebDriverWait getWait() {
        if (wait == null) {
            wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        }
        return wait;
    }
}
