import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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

    public void selectOptionCustom(int index) {
        driver.findElement(By.id("dropdown")).click();
        List<WebElement> options = driver.findElements(By.cssSelector("#dropdown option"));
        options.get(index).click();
    }

    public void selectOptionCustom(String text) {
        driver.findElement(By.id("dropdown")).click();
        List<WebElement> options = driver.findElements(By.cssSelector("#dropdown option"));
        for (WebElement option : options) {
            if (option.getText().equals(text)) {
                option.click();
                break;
            }
        }
    }

        public boolean isOptionEnabled ( int index){
            Select select = new Select(find(By.id("dropdown")));
            return select.getOptions().get(index).isEnabled();
        }
    }
