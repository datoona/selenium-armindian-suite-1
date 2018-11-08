import base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.PublicKey;

public class DragAndDropPage extends BasePage {
    @FindBy(id = "draggable")
    private WebElement columnA;

    @FindBy(id = "droppable")
    private WebElement columnB;


    public DragAndDropPage() {
        super();
        driver.get(getUrl());
    }
    @Override
    public String getUrl() {
        return "http://jqueryui.com/resources/demos/droppable/default.html";
    }

    private void dragAndDrop(WebElement source, WebElement target) {
        getActions().dragAndDrop(source, target).build().perform();
    }

    public void dragAndDropFirstToSecond() {
        dragAndDrop(columnA, columnB);
    }

    public void dragAndDropSecondToFirst() {
        dragAndDrop(columnB, columnA);
    }

    public String getDraggableColumnText() {
        return columnA.getText();
    }
    public String getDropableColumnText() {
        return columnB.getText();
    }

    public String getColorText() {
        return columnB.getCssValue("background");
    }
}
