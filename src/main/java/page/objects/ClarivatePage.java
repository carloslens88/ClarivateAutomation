package page.objects;

import com.beust.ah.A;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClarivatePage extends BasePage {

    private WebDriver driver;

    public ClarivatePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "onetrust-accept-btn-handler")
    @CacheLookup
    private WebElement btnAcceptCookies;

    @FindBy(className = "img-fluid")
    @CacheLookup
    private WebElement imgClarivate;

    @FindBy(xpath = "//a[contains(text(), 'Products & Services')]")
    @CacheLookup
    private WebElement lnkProductsAndServices;

    public void pressAcceptCookiesButton(){
        WaitUntilElementVisible(btnAcceptCookies);
        btnAcceptCookies.click();
    }

    public boolean checkClarivateImage(){
        WaitUntilElementVisible(imgClarivate);
        return imgClarivate.isDisplayed();
    }

    public void clickProductsAndServices(){
        WaitUntilElementVisible(lnkProductsAndServices);
        lnkProductsAndServices.click();
    }

    public void clickLinkOption(String option){
        WebElement lnkOption = driver.findElement(By.linkText(option));
        WaitUntilElementVisible(lnkOption);

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView()", lnkOption);
        jse.executeScript("arguments[0].click()", lnkOption);
    }

    public void clickOnCortellisCMSIntelligence(){
        WebElement h2CMCIntelligence = driver.findElement(By.xpath("//*[@id='oursolutions']/div/div[2]/div[4]/div/a"));
        WaitUntilElementVisible(h2CMCIntelligence);

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView()", h2CMCIntelligence);
        jse.executeScript("arguments[0].click()", h2CMCIntelligence);
    }

    public void pressLoginButton(){
        WebElement linkLogin = driver.findElement(By.xpath("//a[contains(@class, 'nav-link') and contains(text(),'Login')]"));
        WaitUntilElementVisible(linkLogin);
        linkLogin.click();
    }

    public String getLoginCMCIntelligenceURL(){
        String winHandleBefore = driver.getWindowHandle();
        String loginCMCIntelligenceURL = "";

        for(String windowHandle : driver.getWindowHandles()){

            if(windowHandle != winHandleBefore){
                driver.switchTo().window(windowHandle);
                loginCMCIntelligenceURL = driver.getCurrentUrl();
            }
        }

        return loginCMCIntelligenceURL;
    }
}
