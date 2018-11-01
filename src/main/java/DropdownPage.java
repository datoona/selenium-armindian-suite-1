import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownPage extends BasePage {
    @FindBy (id = "dropdown")
    private WebElement dropdown;

    @FindBys({
            @FindBy(css = "#dropdown option")
    })
    private List<WebElement> options;

    public DropdownPage() {
        super();
        PageFactory.initElements(driver, this);
        driver.get(getUrl());
    }

    public String getUrl() {
        return "http://the-internet.herokuapp.com/dropdown";
    }

    public void selectOption(int index) {
        Select select = new Select(dropdown);
        select.selectByIndex(index);
    }

    public void selectOptionCustom(int index) {
        dropdown.click();
        options.get(index).click();
    }

    public void selectOptionCustom(String text) {
        dropdown.click();
        for (WebElement option : options) {
            if (option.getText().equals(text)) {
                option.click();
                break;
            }
        }
    }

    public boolean isOptionEnabled(int index) {
        Select select = new Select(dropdown);
        return select.getOptions().get(index).isEnabled();
    }
}
