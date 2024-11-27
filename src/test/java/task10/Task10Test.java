package task10;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static sviat.dev.task11.DriverPull.getDriver;

public class Task10Test {
    private WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = getDriver();
    }

    @Test
    public void task10() {
        driver.get("https://google.com");
    }
}
