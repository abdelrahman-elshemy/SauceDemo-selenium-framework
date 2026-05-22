package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Helper utility containing shared static methods for test execution support,
 * such as capturing visual evidence upon failures.
 */
public class Helper {

    // Captures a screenshot in byte format and saves it directly to the designated local directory
    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        Path destination = Paths.get("./Screenshots", screenshotName + ".png");

        try {
            Files.createDirectories(destination.getParent());
            FileOutputStream out = new FileOutputStream(destination.toString());

            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }
    }
}