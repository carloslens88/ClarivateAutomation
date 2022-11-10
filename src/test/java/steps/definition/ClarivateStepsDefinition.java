package steps.definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.objects.ClarivatePage;
import page.objects.GooglePage;

import java.time.Duration;

public class ClarivateStepsDefinition {

    private WebDriver driver = Hooks.driver;
    private WebDriverWait wait;
    private GooglePage googlePage;
    private ClarivatePage clarivatePage;

    public ClarivateStepsDefinition() {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        googlePage = new GooglePage(driver, wait);
        clarivatePage = new ClarivatePage(driver, wait);
    }

    @Given("Google search home page")
    public void google_search_home_page() {
        driver.get("https://www.google.com/");
        googlePage.acceptCookies();
    }

    @When("Submit the search term {string}")
    public void submitTheSearchTermQuery(String searchQuery) {
        googlePage.querySearch(searchQuery);
    }

    @When("Press on the expected search result")
    public void press_on_the_expected_search_result() {
        googlePage.clickLinkByText();
    }

    @Then("Success navigation to the web site")
    public void success_navigation_to_the_web_site() {
        clarivatePage.pressAcceptCookiesButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("clarivate"));
        Assert.assertTrue(clarivatePage.checkClarivateImage());
    }

    @When("Click on Products and Services tab")
    public void click_on_products_and_services_tab() {
        clarivatePage.clickProductsAndServices();
    }

    @When("Select option {string} under Biopharma Intelligence")
    public void select_option_under_biopharma_intelligence(String option) {
        clarivatePage.clickLinkOption(option);
    }

    @When("Click on {string}")
    public void click_on(String option) {
        clarivatePage.clickLinkOption(option);
    }

    @When("Choose option Cortellis CMC Intelligence")
    public void choose_option_cortellis_cmc_intelligence() {
        clarivatePage.clickOnCortellisCMSIntelligence();
    }

    @When("Navigate to option {string}")
    public void navigate_to_option(String option) {
        clarivatePage.pressLoginButton();
    }

    @When("Pick up option {string}")
    public void pick_up_option(String option) {
        clarivatePage.clickLinkOption(option);
    }

    @Then("Check the expected URL is {string}")
    public void checkTheExpectedURLIs(String expectedUrl) {
        Assert.assertEquals(clarivatePage.getLoginCMCIntelligenceURL(), expectedUrl);
    }
}