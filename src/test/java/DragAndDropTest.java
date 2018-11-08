import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class DragAndDropTest extends SeleniumBase {

    @Test
    public void dragMe() {
        DragAndDropPage dragAndDropPage = new DragAndDropPage();

        assertEquals("Drag me to my target", dragAndDropPage.getDraggableColumnText(), "Text is not correct!");
        assertEquals("Drop here", dragAndDropPage.getDropableColumnText(), "Text is not correct!");

        dragAndDropPage.dragAndDropFirstToSecond();

        assertEquals("Drag me to my target", dragAndDropPage.getDraggableColumnText(), "Text is not correct!");
        assertEquals("Dropped!", dragAndDropPage.getDropableColumnText(), "Text is not correct!");

        assertTrue(dragAndDropPage.getColorText().contains("rgb(255, 250, 144)"));
    }
}
