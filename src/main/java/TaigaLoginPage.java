import base.BasePage;

public class TaigaLoginPage extends BasePage {
    @Override
    public String getUrl() {
        return "https://tree.taiga.io/login";
    }

    public TaigaLoginPage() {
        super();
        driver.get(getUrl());
    }
}
