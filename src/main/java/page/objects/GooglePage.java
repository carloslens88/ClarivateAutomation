package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GooglePage extends BasePage {

    private WebDriver driver;

    public GooglePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "q")
    @CacheLookup
    private WebElement inputSearch;

    @FindBy(id = "L2AGLb")
    @CacheLookup
    private WebElement cookiesButton;

    public void acceptCookies(){
        WaitUntilElementVisible(cookiesButton);
        cookiesButton.click();
    }

    public void querySearch(String query){
        WaitUntilElementVisible(inputSearch);
        inputSearch.sendKeys(query);
        inputSearch.submit();
    }

    public void clickLinkByText(){
        WebElement clarivateLink = driver.findElement(By.xpath("//h3[contains(text(), 'Clarivate - data')]"));
        WaitUntilElementVisible(clarivateLink);
        clarivateLink.click();
    }
}
