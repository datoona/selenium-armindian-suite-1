import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By usernameField = By.name("login");
    private By passwordField = By.name("password");
    private By signInButton = By.name("commit");
    private By errorMessage = By.cssSelector("#js-flash-container .flash-error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://github.com/login");
    }

    public void loginWith(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(signInButton).click();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }

}
