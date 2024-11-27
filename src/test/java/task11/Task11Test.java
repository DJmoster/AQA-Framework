package task11;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import sviat.dev.task11.LogInBO;
import sviat.dev.task13.MyExecutionListener;
import sviat.dev.task13.MyTestListener;

@Listeners({MyTestListener.class, MyExecutionListener.class})
public class Task11Test {

    @Test
    public void loginTest() {
        new LogInBO()
            .getIndex()
            .openLoginModal()
            .fillUserCredentials()
            .submitLogin()
            .checkIfUserAuthorised()
            .logOut();
    }
}
