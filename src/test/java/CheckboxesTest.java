import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckboxesTest extends SeleniumBase {

    @Test
    public void checkboxesByIndex() {
        CheckBoxPage checkBoxPage = new CheckBoxPage();

        assertFalse(checkBoxPage.isCheckboxChecked(0), "First checkbox was checked!");
        assertTrue(checkBoxPage.isCheckboxChecked(1), "First checkbox was not checked!");

        checkBoxPage.clickCheckbox(0);
        assertTrue(checkBoxPage.isCheckboxChecked(0), "First checkbox was not checked!");
        assertTrue(checkBoxPage.isCheckboxChecked(1), "First checkbox was not checked!");

        checkBoxPage.clickCheckbox(1);
        assertTrue(checkBoxPage.isCheckboxChecked(0), "First checkbox was not checked!");
        assertFalse(checkBoxPage.isCheckboxChecked(1), "First checkbox was checked!");

    }

    @Test
    public void checkboxesByText() {
        CheckBoxPage checkBoxPage = new CheckBoxPage();

        assertFalse(checkBoxPage.isCheckboxChecked("checkbox 1"),
                "First checkbox was checked!");
        assertTrue(checkBoxPage.isCheckboxChecked("checkbox 2"),
                "Second checkbox was not checked!");

        checkBoxPage.clickCheckbox("checkbox 1");
        assertTrue(checkBoxPage.isCheckboxChecked("checkbox 1"),
                "First checkbox was not checked!");
        assertTrue(checkBoxPage.isCheckboxChecked("checkbox 2"),
                "Second checkbox was not checked!");

        checkBoxPage.clickCheckbox("checkbox 2");
        assertTrue(checkBoxPage.isCheckboxChecked("checkbox 1"),
                "First checkbox was not checked!");
        assertFalse(checkBoxPage.isCheckboxChecked("checkbox 2"),
                "Second checkbox was checked!");

    }
}
