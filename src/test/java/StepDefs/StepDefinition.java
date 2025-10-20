package StepDefs;

import RequestSpecs.OMDBReqSpec;
import Tests.IPLocateTest;
import Tests.OMDBTest;
import Tests.WeatherTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class StepDefinition {
    OMDBTest omdbTest=new OMDBTest();
    IPLocateTest ipLocateTest= new IPLocateTest();
    WeatherTest weatherTest=new WeatherTest();
    Response response;

    @When("I request details for the movie with title {string}")
    public void iRequestDetailsForTheMovieWithTitle(String title) {
        omdbTest.prepareRequest(Map.of("t", title));
        response=omdbTest.sendRequest();
    }

    @Then("the response status should be {int}")
    public void theResponseStatusShouldBe(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

    @And("the response should contain the title {string}")
    public void theResponseShouldContainTheTitle(String title) {
        omdbTest.verifyResponsetitle(title);
    }

    @And("the response should contain the year {string}")
    public void theResponseShouldContainTheYear(String year) {
        omdbTest.verifyResponseyear(year);
    }

    @When("I request details for the movie with IMDb ID {string}")
    public void iRequestDetailsForTheMovieWithIMDbID(String id) {
        omdbTest.prepareRequest(Map.of("i", id));
        omdbTest.sendRequest();
    }

    @And("the response should contain the director {string}")
    public void theResponseShouldContainTheDirector(String director) {
        omdbTest.verifyResponseDirector(director);
    }

    @Given("I have a valid IP address {string}")
    public void iHaveAValidIPAddress(String ipAddress) {
        ipLocateTest.getIPAddress(ipAddress);
    }

    @When("I request geolocation information from the IPlocate API")
    public void iRequestGeolocationInformationFromTheIPlocateAPI() {
        ipLocateTest.prepareRequest();
        response=ipLocateTest.sendRequest();
    }

    @And("the country should be {string}")
    public void theCountryShouldBe(String country) {
        ipLocateTest.verifyResponseCountry(country);
    }

    @Given("I have an invalid IP address {string}")
    public void iHaveAnInvalidIPAddress(String ipAddress) {
        ipLocateTest.getIPAddress(ipAddress);
    }

    @And("an error message should be returned")
    public void anErrorMessageShouldBeReturned() {
        ipLocateTest.verifyResponseErrorMessage();
    }

    @When("I request weather information from the Weather API")
    public void iRequestWeatherInformationFromTheWeatherAPI() {
        weatherTest.prepareRequest();
        response=weatherTest.sendRequest();
    }

    @And("the temperature should be returned")
    public void theTemperatureShouldBeReturned() {
        weatherTest.verifyTemperature();
    }

    @Given("I have a latitude {string} and longitude {string}")
    public void iHaveALatitudeAndLongitude(String lat, String lng) {
        weatherTest.getLatLong(lat, lng);
    }
}
