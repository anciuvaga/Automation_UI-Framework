package helpers;

import exceptions.FailMethodInvocationException;
import managers.PageObjectManager;
import org.openqa.selenium.WebElement;
import pages.BasePageObject;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class ElementSearchUtils {

    public static WebElement getWebElementName(TestContext testContext, String pageName, String fieldName) {
        WebElement webElement = null;
        PageObjectManager pageObjectManager = testContext.getPageObjectManager();
        Method getMethodName = null;
        try {
            getMethodName = pageObjectManager.getClass().getMethod("get" + pageName);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        BasePageObject object = null;
        try {
            assert getMethodName != null;
            object = (BasePageObject) getMethodName.invoke(pageObjectManager);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new FailMethodInvocationException("Could not invoke method name" + getMethodName);
        }
        Class<?> validationClass = object.getClass();
        Field[] fields = validationClass.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == WebElement.class) {
                if (field.getName().equals(fieldName)) {
                    try {
                        field.setAccessible(true);
                        webElement = (WebElement) field.get(object);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    finally {
                        field.setAccessible(false);
                    }

                }

            }
        }
        return webElement;
    }


}
