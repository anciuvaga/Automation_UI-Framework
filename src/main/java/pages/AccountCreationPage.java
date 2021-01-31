package pages;

import cucumber.api.DataTable;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import java.util.Map;

@Getter
public class AccountCreationPage extends BasePageObject{

    @FindBy(xpath = "//input[@id='id_gender1']")
    private WebElement genderRadioBtn;

    @FindBy(id = "customer_firstname")
    private WebElement firstName;

    @FindBy(id = "customer_lastname")
    private WebElement lastName;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "days")
    private WebElement dayOfBirth;
    Select dropDownDay;

    @FindBy(id = "months")
    private WebElement monthOfBirth;
    Select dropDownMonth;

    @FindBy(id = "years")
   private WebElement yearOfBirth;
    Select dropDownYear;

    @FindBy(id = "newsletter")
    private WebElement newsletter;

    @FindBy(id = "optin")
    private WebElement optin;

    @FindBy(id = "address1")
    private WebElement address;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_state")
    private WebElement state;
    Select stateName;

    @FindBy(xpath = "//input[@name='postcode']")
    private WebElement postcode;

    @FindBy(id = "phone_mobile")
    private WebElement phone_mobile;

    @FindBy(id = "alias")
    private WebElement aliasAddress;

    @FindBy(id = "submitAccount")
    private WebElement register;

    public AccountCreationPage(WebDriver driver) {
        super(driver);
        dropDownDay = new Select(dayOfBirth);
        dropDownMonth = new Select(monthOfBirth);
        dropDownYear = new Select(yearOfBirth);
        stateName = new Select(state);
    }

    public void enterFirstName(String firstN) {
        firstName.sendKeys(firstN);
    }

    public void enterLastName(String lastN) {
        lastName.sendKeys(lastN);
    }

    public void enterPassword(String pass) {
        password.sendKeys(pass);
    }

    public void selectDay() {
        dropDownDay.selectByValue("5");
    }

    public void selectMonth() {
        dropDownMonth.selectByValue("12");
    }

    public void selectYear() {
        dropDownYear.selectByValue("1991");

    }

    public void enterAddress(String address1) {
        address.sendKeys(address1);
    }

    public void enterCity(String cityName) {
        city.sendKeys(cityName);
    }

    public void selectState() {
        stateName.selectByVisibleText("New Hampshire");
    }

    public void enterPostCode(String zipCode) {
        postcode.sendKeys(zipCode);
    }

    public void enterMobilePhone(String mobile) {
        phone_mobile.sendKeys(mobile);
    }

    public void enterAliasAddress(String allias) {
        aliasAddress.sendKeys(allias);
    }

    public void fillInPersonalDetails(DataTable dataTable) {

        for(Map<String,String> userInfo : dataTable.asMaps(String.class, String.class)){
            enterFirstName(userInfo.get("FirstName"));
            enterLastName(userInfo.get("LastName"));
            enterPassword(userInfo.get("Password"));
            enterAddress(userInfo.get("Address"));
            enterCity(userInfo.get("City"));
            enterPostCode(userInfo.get("ZipCode"));
            enterMobilePhone(userInfo.get("MobilePhone"));
            enterAliasAddress(userInfo.get("AddressAlias"));
        }
    }

    public void completeRegistration() {
        genderRadioBtn.click();
        dayOfBirth.click();
        selectDay();
        monthOfBirth.click();
        selectMonth();
        yearOfBirth.click();
        selectYear();
        optin.click();
        newsletter.click();
        state.click();
        selectState();
    }
}

