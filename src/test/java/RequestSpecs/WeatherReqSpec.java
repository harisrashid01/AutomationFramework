package RequestSpecs;

import Utils.ConfigLoader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class WeatherReqSpec {
    public static RequestSpecification getReqSpec(Map<String, String> queryParams) {
        String url= ConfigLoader.getProperty("weatherurl");
        String endPoint = ConfigLoader.getProperty("weatherendpoint");
        String appId = ConfigLoader.getProperty("weatherappid");

        RequestSpecification requestSpecification=new RequestSpecBuilder().setBaseUri(url).
                setBasePath(endPoint).
                addQueryParams(queryParams).addQueryParam("appid",appId).
                build();

        return requestSpecification;
    }
}
