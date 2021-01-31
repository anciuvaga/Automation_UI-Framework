package pages;

import cucumber.api.DataTable;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Map;

@Getter
public class MyAccountPage extends BasePageObject {

    @FindBy(xpath = "//span[contains(text(),'John Dow')]")
    private WebElement userAcctName;

    @FindBy(xpath = "//a[@class ='logout']")
    private WebElement signOut;

    @FindBy(xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[1]/a[1]")
    private WebElement category;

    @FindBy(css = ".header_user_info > .account")
    private WebElement account;

    @FindBy(xpath = "//ul[@class='myaccount-link-list']/li[4]/a[1]")
    private WebElement myPersonalInformation;

    @FindBy(id = "old_passwd")
    private WebElement oldPass;

    @FindBy(id = "passwd")
    private WebElement newPass;

    @FindBy(name = "confirmation")
    private WebElement confirmPass;

    @FindBy(name = "submitIdentity")
    private WebElement save;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    private WebElement personalInformationUpdateMessage;

    @FindBy(xpath = "//table//tbody")
    private WebElement orderRef;

    @FindBy(xpath = "//table[@class='table table-bordered']//tbody/tr[1]//td[2]//label")
    private WebElement productName;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getAccountName() {
        return userAcctName.getText();
    }

    public void enterOldPassword(String oldPassword) {
        oldPass.sendKeys(oldPassword);
    }

    public void enterNewPassword(String newPassword) {
        newPass.sendKeys(newPassword);
    }

    public void confirmNewPassword(String confirmNewPassword) {
        confirmPass.sendKeys(confirmNewPassword);
    }

    public void updatePassword(DataTable dataTable) {
        for (Map<String, String> updateInfo : dataTable.asMaps(String.class, String.class)) {
            enterOldPassword(updateInfo.get("CurrentPassword"));
            enterNewPassword(updateInfo.get("NewPassword"));
            confirmNewPassword(updateInfo.get("Confirmation"));
        }
    }

    public boolean successfulInformationUpdatetMessage() {
        return personalInformationUpdateMessage.isDisplayed();
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getOrderReference() {return orderRef.getText();}

}

