package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class AmazonStepDefinitions {
    AmazonPage amazonPage = new AmazonPage();

    @Given("User goes to {string} home page.")
    public void user_goes_to_home_page(String AmazonUrl) {
        Driver.getDriver().get(ConfigReader.getProperty("AmazonUrl"));

    }
    @Then("User makes searching for {string}.")
    public void user_makes_searching_for(String product) {
        amazonPage=new AmazonPage();
    amazonPage.amazonAramaKutusu.sendKeys(product + Keys.ENTER);
    }
    @Then("User waits {int} minutes")
    public void user_waits_minutes(Integer minute) {
        try {
            Thread.sleep(minute*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @Then("User tests whether the results contains {string}.")
    public void user_tests_whether_the_results_contains(String product) {
       String actualResult= amazonPage.aramaSonucuElementi.getText();
        Assert.assertTrue(actualResult.contains(product));
    }


    @And("User closes driver")
    public void userClosesDriver() {
        Driver.closeDriver();
    }
}
