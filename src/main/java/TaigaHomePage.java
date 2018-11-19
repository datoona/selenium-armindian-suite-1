import base.BasePage;
import base.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TaigaHomePage extends BasePage {
    @FindBy(css = "[title='Projects']")
    private WebElement projectsIcon;


    @Override
    public String getUrl() {
        return "https://tree.taiga.io/login";
    }

    public TaigaHomePage() {
        super();
        driver.get(getUrl());
    }

    public TaigaProjectsPage clickProjectsIcon() {
        WaitHelper.getWait().waitForElementToBeVisible(projectsIcon);
        click(projectsIcon);
        return (TaigaProjectsPage) new TaigaProjectsPage().get();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void isLoaded() {
        new WebDriverWait(driver, 20).
                until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".loader.active")));
        new WebDriverWait(driver, 20).
                until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".loader.active"))));
    }


}
