package task12;

import com.automation.remarks.testng.UniversalVideoListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import sviat.dev.task12.LogIn12BO;
import sviat.dev.task13.MyExecutionListener;
import sviat.dev.task13.MyTestListener;

@Listeners({MyTestListener.class, MyExecutionListener.class, UniversalVideoListener.class})
public class Task12LoginTest {

    @Test(description = "Login modal test suite")
    public void loginTest() {
        new LogIn12BO()
                .getIndex()
                .openLoginModal()
                .fillUserCredentials()
                .submitLogin()
                .checkIfUserAuthorised()
                .logOut()
                .closeDriver();
    }

    @Test(description = "Login modal test suite")
    public void loginFailTest() {
        new LogIn12BO()
                .getIndex()
                .openLoginModal()
                .fillUserCredentials()
                .checkIfUserAuthorised()
                .logOut()
                .closeDriver();
    }
}
