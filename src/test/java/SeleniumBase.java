import org.testng.annotations.AfterMethod;

import static base.DriverHelper.getDriver;

public class SeleniumBase {
    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }
}
