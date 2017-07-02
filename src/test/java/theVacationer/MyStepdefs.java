package theVacationer;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

/**
 * Created by Peter on 7/2/2017.
 */
public class MyStepdefs {
  @Given("^I have a scenario$")
  public void iHaveAScenario() throws Throwable {
    //na
  }

  @When("^I run the tests$")
  public void iRunTheTests() throws Throwable {
    //na
  }

  @Then("^all the tests go green$")
  public void allTheTestsGoGreen() throws Throwable {
    //na
  }

  @Given("^A specific location$")
  public void aSpecificLocation() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    assertEquals(1,1);
  }

  @When("^I chose to locate available restaurants$")
  public void iChoseToLocateAvailableRestaurants() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    assertEquals(1,1);
  }

  @Then("^They're are (\\d+) available restaurants$")
  public void theyReAreAvailableRestaurants(int arg0) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    assertEquals(1,1);
  }
}
