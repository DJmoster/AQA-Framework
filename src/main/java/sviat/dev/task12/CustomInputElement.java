package sviat.dev.task12;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static sviat.dev.task11.DriverPull.getWait;

public class CustomInputElement extends Element {

    public CustomInputElement(WebElement webElement) {
        super(webElement);
    }

    public void input(String text) {
        webElement.sendKeys(text);
        System.out.println("Text entered: " + text);
    }

    public boolean isVisible() {
        return webElement.isDisplayed();
    }

    public void waitForMeAndInput(String text) {
        getWait().until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys(text);

        System.out.println("[waitForMeAndInput] Text entered: " + text);
    }
}
