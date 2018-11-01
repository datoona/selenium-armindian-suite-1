import org.testng.annotations.AfterMethod;

import static base.DriverHelper.getDriver;
import static base.DriverHelper.quitDriver;

public class SeleniumBase {
    @AfterMethod
    public void tearDown() {
        quitDriver();
    }
}
