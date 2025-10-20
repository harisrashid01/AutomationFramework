package Tests;

import POJO.IPLocate.IPLocateResponse;
import RequestSpecs.IPLocateReqSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import static org.hamcrest.Matchers.equalTo;

public class IPLocateTest {
    private RequestSpecification requestSpecification;
    private String ipAddress;
    private Response response;
    private IPLocateResponse ipLocateResponse;

    public void getIPAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void prepareRequest() {
        requestSpecification= IPLocateReqSpec.getReqSpec(ipAddress);
    }

    public Response sendRequest() {
        response= RestAssured.given().spec(requestSpecification).when().get();
        return response;
    }

    public void verifyResponseCountry(String country) {
        ipLocateResponse = response.as(IPLocateResponse.class);
        Assert.assertTrue(ipLocateResponse.getCountry().equalsIgnoreCase(country));
    }

    public void verifyResponseErrorMessage() {
        Assert.assertTrue(
                response.jsonPath().getString("error").contains("Invalid IP address")
        );
    }
}
