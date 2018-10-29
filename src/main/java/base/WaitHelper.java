package base;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
    public static WaitHelper getWait() {
        WaitHelper waitHelper = new WaitHelper();
        return waitHelper;
    }

    public void waitForElementToBeVisible(By location) {
//        new WebDriverWait().until()
    }

}
