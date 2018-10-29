import org.testng.annotations.Test;

import static base.DriverHelper.getDriver;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class LoginTest extends SeleniumBase {


    @Test
    public void successLogin() {
        getDriver().get("https://www.google.com");

        assertTrue(getDriver().getCurrentUrl().contains("https://www.google.com"),
                "The page was not load correctly");

    }

    @Test
    public void githubFailedLogin() {
        LoginPage loginPage =  new LoginPage();

        assertFalse(loginPage.isErrorMessageDisplayed(), "Error message should not displayed!");
        loginPage.loginWith("mail@mail.am", "Password");

        assertTrue(loginPage.isErrorMessageDisplayed(), "Error message was not displayed!");
    }


}
