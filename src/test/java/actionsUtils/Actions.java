package actionsUtils;

import org.openqa.selenium.WebElement;

public class Actions {

    public static void clickOnElement(WebElement element) {
        element.click();
    }

    public static void sendKeysToField(WebElement element, String value) {
        element.sendKeys(value);
    }
}
