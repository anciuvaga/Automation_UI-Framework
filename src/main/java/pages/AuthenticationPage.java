package pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter
public class AuthenticationPage {
WebDriver driver;

    public AuthenticationPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

   @FindBy(xpath = "//h1[@class='page-heading']")
    private WebElement pageHeader;

    @FindBy(xpath = "//input[@id='email_create']")
    private WebElement emailCreate;

    @FindBy(id = "SubmitCreate")
    private WebElement createAccountBtn;

    @FindBy(id = "email")
    private WebElement emailAuthentication;

    @FindBy(id = "passwd")
    private WebElement passwordAuthentication;

    @FindBy(id = "SubmitLogin")
    private WebElement submitLogin;

    public String getHeader() {
        return pageHeader.getText();
    }

    public void inputEmail(String email) {
        emailCreate.sendKeys(email);
    }

}
