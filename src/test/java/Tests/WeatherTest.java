package Tests;

import POJO.Weather.WeatherResponse;
import RequestSpecs.IPLocateReqSpec;
import RequestSpecs.WeatherReqSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.util.Map;

public class WeatherTest {
    private RequestSpecification requestSpecification;
    Response response;
    String lat;
    String lng;

    public void prepareRequest() {
        requestSpecification= WeatherReqSpec.getReqSpec(Map.of("lat", lat, "lon", lng));
    }

    public Response sendRequest() {
        response= RestAssured.given().spec(requestSpecification).when().get();
        return response;
    }

    public void verifyTemperature() {
        WeatherResponse weatherResponse = response.as(WeatherResponse.class);
        Double temp = weatherResponse.getMain().getTemp();

        Assert.assertNotNull(temp);
    }

    public void getLatLong(String lat, String lng) {
        this.lat=lat;
        this.lng=lng;
    }
}
