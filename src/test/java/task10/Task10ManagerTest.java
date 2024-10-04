package task10;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Task10ManagerTest {
    private WebDriver driver;

    private WebElement loginBtn;
    private WebElement usernameInput;
    private WebElement passwordInput;
    private WebElement loginSubmit;

    @BeforeClass
    public void setup() {
        ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

    @Test
    public void testIfElementsExists() {
        driver.get("https://www.demoblaze.com/index.html");
        driver.manage().window().maximize();

        loginBtn = driver.findElement(By.id("login2"));

        usernameInput = driver.findElement(By.id("loginusername"));
        passwordInput = driver.findElement(By.id("loginpassword"));
        loginSubmit = driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]"));

        Assert.assertTrue(loginBtn.isDisplayed());

        Assert.assertFalse(usernameInput.isDisplayed());
        Assert.assertFalse(passwordInput.isDisplayed());
        Assert.assertFalse(loginSubmit.isDisplayed());
    }

    @Test(dependsOnMethods = {"testIfElementsExists"})
    public void testIfLoginModalIsDisplayed() {
        loginBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.visibilityOf(usernameInput));
        wait.until(ExpectedConditions.visibilityOf(passwordInput));
        wait.until(ExpectedConditions.visibilityOf(loginSubmit));
    }

    @Test(dependsOnMethods = {"testIfLoginModalIsDisplayed"})
    public void testUserLogin() {
        usernameInput.sendKeys("test");
        passwordInput.sendKeys("test");

        loginSubmit.click();
    }
}
