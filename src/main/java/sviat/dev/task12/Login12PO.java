package sviat.dev.task12;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static sviat.dev.task11.DriverPull.getDriver;

public class Login12PO {

    @FindBy(id = "login2")
    private WebElement loginButton;

    @FindBy(id = "loginusername")
    private CustomInputElement usernameField;

    @FindBy(id = "loginpassword")
    private CustomInputElement passwordField;

    @FindBy(xpath = "//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")
    private WebElement loginSubmit;

    @FindBy(id = "logInModal")
    private WebElement modal;

    @FindBy(id = "nameofuser")
    private WebElement nameOfUser;

    @FindBy(id = "logout2")
    private WebElement logOutButton;

    public Login12PO() {
        PageFactory.initElements(new MyFieldDecorator(getDriver()), this);
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public CustomInputElement getUsernameField() {
        return usernameField;
    }

    public CustomInputElement getPasswordField() {
        return passwordField;
    }

    public WebElement getLoginSubmit() {
        return loginSubmit;
    }

    public WebElement getModal() {
        return modal;
    }

    public WebElement getNameOfUser() {
        return nameOfUser;
    }

    public WebElement getLogOutButton() {
        return logOutButton;
    }
}
