package TestComponent;

public class XPathConstants {
    public static final String Login_name = "//span[contains(.,'Login')]";
    public static final String Login_password = "//span[contains(.,'Password:')]";
    public static final String Signin = "//button[@class='action-login action-primary']//span[.='Sign in']";
    public static final String All_customer = "//ul[@role='menu']/li/a[contains(.,'All Customers')]";
    public static final String First_name_filed = "//input[@name='customer[firstname]']";
    public static final String Last_name_filed = "//input[@name='customer[lastname]']";
    public static final String Email_filed = "//input[@name='customer[email]']";
    public static final String Search_keyword = "//input[contains(@placeholder,'Search by keyword')]";
    public static final String Data_row = "//tr[@data-repeat-index]";
    public static final String Data_row_result = "//div[@class='col-xs-3']//div[@class='admin__control-support-text']";
    public static final String Edit_button = ".//a[text()='Edit']";
    public static final String Keyword = "//div[@class='admin__current-filters-list-wrap']//li//span[contains(@data-bind,'text: preview')]";
}
