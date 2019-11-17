package com.uitestingplayground.stepsDefinition;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pageObjects.SampleAppPage;

public class SampleAppPageSteps {

    private TestContext testContext;
    private SampleAppPage sampleAppPage;

    public SampleAppPageSteps(TestContext context) {
        testContext = context;
        sampleAppPage = testContext.getPageObjectManager().getSampleAppPage();
    }
    @Then("^I assert that the page is loaded$")
    public void iAssertThatThePageIsLoaded() {
        Assert.assertEquals(sampleAppPage.getSampleAppTitle(),"Sample App");
    }

    @When("^I fill username \"([^\"]*)\"$")
    public void iFillUsername(String username) throws InterruptedException {
        sampleAppPage.fillUsername(username);
    }

    @When("^I fill password \"([^\"]*)\"$")
    public void iFillPassword(String pass){
        sampleAppPage.fillPassword(pass);
    }

    @When("^I click the submit button$")
    public void iClickTheSubmitButton() {
        sampleAppPage.clickLoginButton ();
    }

    @Then("^I assert successful login$")
    public void iAssertSuccessfulLogin() {
        Assert.assertEquals(sampleAppPage.getSuccessLoginText(),"Welcome, test!");
    }

    @Then("^I assert unsuccessful login$")
    public void iAssertUnsuccessfulLogin() {
        Assert.assertEquals(sampleAppPage.getUnSuccessLoginText(),"Invalid username/password");
    }

    @When("^I wait full load$")
    public void iWaitFullLoad() {
        sampleAppPage.waitFullLoad();
    }
}
