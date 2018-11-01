import base.BasePage;
import base.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoadingPage extends BasePage {
    @FindBy(css = "#start button")
    private WebElement startButton;

    @FindBy(css = "#finish h4")
    private WebElement finishText;


    public LoadingPage() {
        super();
        driver.get(getUrl());
    }

    @Override
    public String getUrl() {
        return "http://the-internet.herokuapp.com/dynamic_loading/1";
    }

    public void clickStart() {
        click(startButton);
        WaitHelper.getWait().waitForElementToBeVisible(finishText);
    }

    public boolean isFinishTextDisplayed() {
        return isDisplayed(finishText);
    }

    public String getFinishText() {
        return finishText.getText();
    }

    @Override
    public void isLoaded() {
        WaitHelper.getWait().waitForElementToBeVisible(startButton);
    }

}
