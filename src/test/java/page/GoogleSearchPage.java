package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.List;

public class GoogleSearchPage extends GoogleBasePage{

    @FindBy(id = "lst-ib")
    public WebElement searchField;

    @FindBy(css="h3.r > a")
    public List<WebElement> resultsWebElementList;

    @FindBy(css="a#pnnext")
    public WebElement nextPage;

    public GoogleSearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GoogleSearchPage searchByTerm(String searchTerm) {
        searchField.sendKeys(searchTerm);
        searchField.submit();
        return new GoogleSearchPage(driver);
    }

    public List<String> getResults() {
        List<String> resultsStringList = new ArrayList();
        for (WebElement result : resultsWebElementList) {
            ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", result);
            String cardTitle = result.getText();
            resultsStringList.add(cardTitle);
        }
        return resultsStringList;
    }

    public GoogleSearchPage clickToNextPage() {
        nextPage.click();
        return new GoogleSearchPage(driver);
    }

}
