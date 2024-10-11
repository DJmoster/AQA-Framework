package sviat.dev.task12;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static sviat.dev.task11.DriverPull.getDriver;
import static sviat.dev.task11.DriverPull.getWait;

public class LogIn12BO {
    private final Login12PO loginPO;

    public LogIn12BO() {
        loginPO = new Login12PO();
    }

    public LogIn12BO getIndex() {
        getDriver().get("https://www.demoblaze.com/index.html");

        return this;
    }

    public LogIn12BO openLoginModal() {
        loginPO.getLoginButton().click();
        getWait().until(ExpectedConditions.visibilityOf(loginPO.getModal()));

        return this;
    }

    public LogIn12BO fillUserCredentials() {
        loginPO.getUsernameField().waitForMeAndInput("test");
        loginPO.getPasswordField().waitForMeAndInput("test");

        return this;
    }

    public LogIn12BO submitLogin() {
        loginPO.getLoginSubmit().click();
        getWait().until(ExpectedConditions.invisibilityOf(loginPO.getModal()));

        return this;
    }

    public LogIn12BO checkIfUserAuthorised() {
        getWait().until(ExpectedConditions.visibilityOf(loginPO.getNameOfUser()));
        Assert.assertEquals(loginPO.getNameOfUser().getText(), "Welcome test");

        return this;
    }

    public LogIn12BO logOut() {
        getWait().until(ExpectedConditions.visibilityOf(loginPO.getLogOutButton()));
        loginPO.getLogOutButton().click();

        getWait().until(ExpectedConditions.invisibilityOf(loginPO.getNameOfUser()));

        return this;
    }

    public void closeDriver() {
        getDriver().quit();
    }
}
