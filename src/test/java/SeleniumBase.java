import base.DriverHelper;
import org.testng.annotations.AfterMethod;


public class SeleniumBase {
    @AfterMethod
    public void tearDown() {
        DriverHelper.get().quitDriver(DriverHelper.get().getDriver());
    }
}
