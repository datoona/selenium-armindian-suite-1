import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {
    public DropdownPage(WebDriver driver) {
        super(driver);
        driver.get(getUrl());
    }

    public String getUrl() {
        return "http://the-internet.herokuapp.com/dropdown";
    }

    public void selectOption(int index) {
        Select select = new Select(find(By.id("dropdown")));
        select.selectByIndex(index);
    }

    public boolean isOptionEnabled(int index) {
        Select select = new Select(find(By.id("dropdown")));
        return select.getOptions().get(index).isEnabled();
    }
}
