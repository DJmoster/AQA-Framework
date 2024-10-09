package sviat.dev.task11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPO {
    WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.id("login2"));
    }

    public WebElement getUsernameField() {
        return driver.findElement(By.id("loginusername"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("loginpassword"));
    }

    public WebElement getLoginSubmit() {
        return driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]"));
    }

    public WebElement getModal() {
        return driver.findElement(By.id("logInModal"));
    }

    public WebElement getNameOfUser() {
        return driver.findElement(By.id("nameofuser"));
    }

    public WebElement getLogOutButton() {
        return driver.findElement(By.id("logout2"));
    }
}
