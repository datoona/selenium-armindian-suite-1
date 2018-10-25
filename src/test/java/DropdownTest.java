import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class DropdownTest {
    private WebDriver driver;


    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver",
                "./src/main/resources/drivers/chromedriver-mac-64bit");
        driver = new ChromeDriver();
    }

    @Test
    public void successLogin() {
        DropdownPage dropdownPage = new DropdownPage(driver);

        dropdownPage.selectOption(1);
        dropdownPage.isOptionEnabled(0);



    }
}
