package Tests;

import POJO.OMDB.OMDBResponse;
import RequestSpecs.OMDBReqSpec;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Map;

public class OMDBTest {
    RequestSpecification requestSpecification;
    Response response;
    OMDBResponse omdbResponse;

    @Test
    public void prepareRequest(Map<String, String> queryParams) {
        requestSpecification= OMDBReqSpec.getReqSpec(queryParams);
    }

    @Test
    public Response sendRequest() {
        response= RestAssured.given().spec(requestSpecification).when().get();
        return response;
    }

    @Test
    public void verifyResponsetitle(String title) {
        omdbResponse = response.as(OMDBResponse.class);
        Assert.assertTrue(omdbResponse.getTitle().equalsIgnoreCase(title));
    }

    @Test
    public void verifyResponseyear(String year) {
        omdbResponse = response.as(OMDBResponse.class);
        Assert.assertTrue(omdbResponse.getYear().equals(year));
    }

    @Test
    public void verifyResponseDirector(String director) {
        omdbResponse = response.as(OMDBResponse.class);
        Assert.assertTrue(omdbResponse.getDirector().equalsIgnoreCase(director));
    }
}
