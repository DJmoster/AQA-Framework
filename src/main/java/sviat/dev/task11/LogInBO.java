package sviat.dev.task11;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static sviat.dev.task11.DriverPull.getDriver;
import static sviat.dev.task11.DriverPull.getWait;

public class LogInBO {
    private final LoginPO loginPO;

    public LogInBO() {
        loginPO = new LoginPO(getDriver());
    }

    public LogInBO getIndex() {
        getDriver().get("https://www.demoblaze.com/index.html");

        return this;
    }

    public LogInBO openLoginModal() {
        loginPO.getLoginButton().click();
        getWait().until(ExpectedConditions.visibilityOf(loginPO.getModal()));

        return this;
    }

    public LogInBO fillUserCredentials() {
        loginPO.getUsernameField().sendKeys("test");
        loginPO.getPasswordField().sendKeys("test");

        return this;
    }

    public LogInBO submitLogin() {
        loginPO.getLoginSubmit().click();
        getWait().until(ExpectedConditions.invisibilityOf(loginPO.getModal()));

        return this;
    }

    public LogInBO checkIfUserAuthorised() {
        getWait().until(ExpectedConditions.visibilityOf(loginPO.getNameOfUser()));
        Assert.assertEquals(loginPO.getNameOfUser().getText(), "Welcome test");

        return this;
    }

    public LogInBO logOut() {
        getWait().until(ExpectedConditions.visibilityOf(loginPO.getLogOutButton()));
        loginPO.getLogOutButton().click();

        getWait().until(ExpectedConditions.invisibilityOf(loginPO.getNameOfUser()));

        return this;
    }

}
