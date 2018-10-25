import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private By usernameField = By.name("login");
    private By passwordField = By.name("password");
    private By signInButton = By.name("commit");
    private By errorMessage = By.cssSelector("#js-flash-container .flash-error");

    public LoginPage(WebDriver driver) {
        super(driver);
        driver.get(getUrl());
    }

    public String getUrl() {
        return "https://github.com/login";
    }

    public void loginWith(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(signInButton);
    }

    public boolean isErrorMessageDisplayed() {
        return isDisplayed(errorMessage);
    }


}
