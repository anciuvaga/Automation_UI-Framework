package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePageObject {
    private WebDriver driver;


   public BasePageObject (WebDriver driver){
       this.driver = driver;
       PageFactory.initElements(driver, this);
   }

}
