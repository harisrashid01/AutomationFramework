package RequestSpecs;

import Utils.ConfigLoader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class OMDBReqSpec {

    public static RequestSpecification getReqSpec(Map<String, String> queryParams) {
        String url= ConfigLoader.getProperty("omdburl");
        String apiKey = ConfigLoader.getProperty("omdbapikey");

        RequestSpecification requestSpecification=new RequestSpecBuilder().setBaseUri(url)
                .addQueryParams(queryParams).addQueryParam("api_key", apiKey).
                build();

        return requestSpecification;
    }
}
