package webElementsEnum;

import org.openqa.selenium.By;

import java.util.Arrays;

public enum WebElements {

    SIGN_IN("//a[@class='login']","Sign In"),
    CREATE_AN_ACCOUNT("//button[@class='btn btn-default button button-medium exclusive']", "Create an account"),
    REGISTER("//button[@name='submitAccount']", "Register"),
    SIGN_OUT("//a[@class ='logout']", "Sign Out"),
    I_CONFIRM_MY_ORDER("//button[@class='button btn btn-default button-medium']", "I confirm my order"),
    ACCOUNT("//a[@class='account']", "Account"),
    MY_PERSON_INFORMATION("//i[@class='icon-user']", "My personal information"),
    SAVE("//button[@name='submitIdentity']", "Save");

    private String businessName;

    private String webElement;

    WebElements(String webElement, String businessName) {
        this.webElement = webElement;
        this.businessName = businessName;
    }

    public String getAttribute() {
        return webElement;
    }

    public By selector() {
        return By.xpath(getAttribute());

    }

    public static WebElements getByBusinessName(String businessName){
        return Arrays.stream(WebElements.values())
                .filter(x -> x.businessName.equals(businessName))
                .findFirst().orElseThrow(() -> new RuntimeException("Element not found"));
    }
}
