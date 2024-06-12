package Data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CustomerData {
    public String[] customerDetails = new String[3];

    public CustomerData() throws IOException {
        Properties prop = new Properties();

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\data/data.properties");
        prop.load(fis);
        customerDetails[0] = prop.getProperty("Name");
        customerDetails[1] = prop.getProperty("LastName");
        customerDetails[2] = prop.getProperty("Email");
    }
}

