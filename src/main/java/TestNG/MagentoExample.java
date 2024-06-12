package TestNG;
import Data.CustomerData;
import TestComponent.BaseClass;
import TestComponent.XPathConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class MagentoExample extends BaseClass {
    private static WebDriver driver;
    private static String sharedValue;
    private static WebDriverWait wait;
    private static String[] customerDetails;

    @BeforeClass
    public static void setUp() throws IOException {
        CustomerData customerData = new CustomerData();
        customerDetails = customerData.customerDetails;
        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("https://magento2demo.firebearstudio.com/");
        String userName = driver.findElement(By.xpath(XPathConstants.Login_name)).getText();
        System.out.println(userName);
        String[] updateUsername = userName.split(": ");
        System.out.println(updateUsername[1]);
        String password = driver.findElement(By.xpath(XPathConstants.Login_password)).getText();
        System.out.println(password);
        String[] updatePassword = password.split(": ");
        System.out.println(updatePassword[1]);

        driver.findElement(By.linkText("Log into the administrator panel")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username"))).sendKeys(updateUsername[1]);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login"))).sendKeys(updatePassword[1]);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPathConstants.Signin))).click();
    }
    
    @Test
    public void addCustomer() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu-magento-customer-customer"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPathConstants.All_customer))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("add"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPathConstants.First_name_filed))).sendKeys(customerDetails[0]);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPathConstants.Last_name_filed))).sendKeys(customerDetails[1]);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPathConstants.Email_filed))).sendKeys(customerDetails[2]);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("save"))).click();
    }

    @Test(dependsOnMethods = "addCustomer")
    public void searchCustomer() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPathConstants.Search_keyword))).clear();
        WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPathConstants.Search_keyword)));
        searchField.sendKeys(customerDetails[0]);
        searchField.sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(XPathConstants.Data_row)));
        List<WebElement> dataRows = driver.findElements(By.xpath(XPathConstants.Data_row));
        int rowCount = dataRows.size();
        String newRowCount = rowCount + " records found";
        sharedValue = newRowCount;
        System.out.println(newRowCount);
    }

    @Test(dependsOnMethods = "searchCustomer")
    public void matchNumOfRows() {
        String getTextOfRecords = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPathConstants.Data_row_result))).getText();
        System.out.println(getTextOfRecords);
        assertEquals(sharedValue, getTextOfRecords);
        WebElement rowData = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr[contains(.,'" + customerDetails[0] + "')]")));
        WebElement editButton = rowData.findElement(By.xpath(XPathConstants.Edit_button));
        assertEquals(driver.findElement(By.xpath(XPathConstants.Keyword)).getText(),customerDetails[0]);
        wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        if (driver != null) {
            driver.quit();
        }
    }
}
