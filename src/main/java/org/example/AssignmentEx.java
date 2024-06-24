package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AssignmentEx {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();
        String getText = driver.findElement(By.xpath("//label[contains(.,'Option2')]")).getText();
        WebElement StaticDropdown = driver.findElement(By.id("dropdown-class-example"));
        Select dropdown = new Select(StaticDropdown);
        dropdown.selectByVisibleText(getText);
        driver.findElement(By.id("name")).sendKeys(getText);
        driver.findElement(By.id("alertbtn")).click();
        String popupText = driver.switchTo().alert().getText();
        if (popupText.contains(getText)) {
            System.out.println("The alert text contains the "+ getText +" is available.");
        } else {
            System.out.println("The alert text does not contain the "+ getText +".");
        }
    }
}
