package task12;

import org.testng.annotations.Test;
import sviat.dev.task12.LogIn12BO;

public class Task12LoginTest {

    @Test
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
}
