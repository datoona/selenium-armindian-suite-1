import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class HoverTest extends SeleniumBase {

    @Test
    public void hoverTest() {
        HoverPage hoverPage = new HoverPage();
        assertFalse(hoverPage.isFooterDisplayed());

        hoverPage.hoverElement();
        assertTrue(hoverPage.isFooterDisplayed());
    }
}
