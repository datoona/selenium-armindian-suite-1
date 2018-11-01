import base.BasePage;
import base.WaitHelper;
import com.sun.xml.internal.rngom.parse.host.Base;
import org.openqa.selenium.By;

public class LoadingPage extends BasePage {

    private By startButton = By.cssSelector("#start button");
    private By finishText = By.cssSelector("#finish h4");

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
        return find(finishText).getText();
    }

}
