package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConfigureBrowser {

    public static void main(String[] args) {
        // Set the system property for ChromeDriver
//        System.setProperty("webdriver.chrome.driver", "C:/tools/chromedriver.exe");

        // Initialize the ChromeDriver
        FirefoxDriver driver = new FirefoxDriver();

//        WebDriver driver = new ChromeDriver();

        // Navigate to a website
        driver.get("https://www.google.com");
        // Print the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Page URL is: " + driver.getCurrentUrl());

        // Close the browser
        driver.quit();
    }
}
