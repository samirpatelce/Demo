package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class GetScreenShot {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
        ss(driver, "C:\\Users\\Samir\\Downloads\\1.png");
    }

    public static void ss(WebDriver driver, String filePath) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        // Capture screenshot as a file
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        // Move the file to the desired location
        FileUtils.copyFile(srcFile, new File(filePath));

    }
}
