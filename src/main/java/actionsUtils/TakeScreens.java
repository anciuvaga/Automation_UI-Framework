package actionsUtils;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TakeScreens {

    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
    private static LocalDateTime now = LocalDateTime.now();
    private static String nowTime = dtf.format(now);
    private String folderPath;

    public TakeScreens() {
        folderPath = createScreenShotPath();
    }

    public String getScreenPath() {
        if (folderPath == null) {
            folderPath = createScreenShotPath();
        }
        return folderPath;
    }

    private String createScreenShotPath() {
        try
        {
            DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
            Date date = new Date();
            String currentDateTime = dateFormat.format(date);

            String folderPath = System.getProperty("user.dir") + "/test-output/cucumber-reports/screenshots/" + currentDateTime;
            File file = new File(folderPath);

            if (!file.exists())
            {
                file.mkdir();
                return folderPath;
            }
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     *  Copy taken screenshot from source location to destination location
     */

    /**
     * This attach the specified screenshot to the test
     */
    public static void takeScreenshot(WebDriver driver, String screenshotsPath) {

        String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());

        try {
            File fileSource = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destinationPath = new File(screenshotsPath + "/"+ timestamp + ".png");
            Files.copy(fileSource, destinationPath);
            Reporter.addScreenCaptureFromPath(destinationPath.toString());
        } catch (IOException e) {
            System.out.println("Error while taking screenshot " + e.getMessage());
        }
    }
}
