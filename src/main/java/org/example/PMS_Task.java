package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.time.Duration;

public class PMS_Task {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://pms.tridhyatech.com/login");

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("samir.p@tridhyatech.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("tridhya@111");  // Assuming this is intentionally empty

        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
        driver.findElement(By.xpath("//i[@class='fas fa-clock']")).click();
        driver.findElement(By.xpath("(//a[text()='View Summary'])[1]")).click();

        By currentTimePath = By.xpath("//tr[contains(.,'Today Entry')]//span");
        WebElement currentTimeElement = driver.findElement(currentTimePath);
        String currentTime = currentTimeElement.getText();

        JOptionPane.showMessageDialog(null, "Current Time: " + currentTime);

        driver.quit();
    }

}
