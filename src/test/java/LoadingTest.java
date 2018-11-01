import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoadingTest extends SeleniumBase {

    @Test
    public void loadingText() {
        LoadingPage loadingPage = (LoadingPage) new LoadingPage().get();

        loadingPage.clickStart();
        assertTrue(loadingPage.isFinishTextDisplayed(), "Finish Text should be Visible!");
        assertEquals(loadingPage.getFinishText(),"Hello World!", "Finish Text was not correct!");
    }
}
