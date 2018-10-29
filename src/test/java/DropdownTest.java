import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class DropdownTest extends SeleniumBase {


    @BeforeMethod
    public void setup() {

    }

    @Test
    public void successLogin() {
        DropdownPage dropdownPage = new DropdownPage();

        dropdownPage.selectOptionCustom("Option 1");



    }
}
