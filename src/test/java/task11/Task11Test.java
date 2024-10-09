package task11;

import org.testng.annotations.Test;
import sviat.dev.task11.LogInBO;

public class Task11Test {

    @Test
    public void loginTest() {
        new LogInBO()
            .getIndex()
            .openLoginModal()
            .fillUserCredentials()
            .submitLogin()
            .checkIfUserAuthorised()
            .logOut()
            .closeDriver();
    }
}
