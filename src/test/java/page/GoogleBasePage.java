package page;

import org.openqa.selenium.WebDriver;


public class GoogleBasePage {
    WebDriver driver;

    public GoogleBasePage (WebDriver driver){
        this.driver = driver;
    }
    public String getPageTitle() {
        return driver.getTitle();
    }
    public String getPageUrl() {
        return driver.getCurrentUrl();
    }
}

