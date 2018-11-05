import org.testng.annotations.Test;

public class CheckboxesTest extends SeleniumBase {

    @Test
    public void checkboxes() {
        CheckBoxPage checkBoxPage = new CheckBoxPage();
        checkBoxPage.isCheckboxChecked(0);
    }
}
