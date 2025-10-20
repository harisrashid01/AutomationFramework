package RequestSpecs;

import Utils.ConfigLoader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class IPLocateReqSpec {

    public static RequestSpecification getReqSpec(String ip) {
        String url= ConfigLoader.getProperty("iplocateurl");
        String endPoint = ConfigLoader.getProperty("iplocateendpoint");
        String apiKey = ConfigLoader.getProperty("iplocateapikey");

        RequestSpecification requestSpecification=new RequestSpecBuilder().setBaseUri(url).
                setBasePath(endPoint).
                addPathParam("ip",ip).addQueryParam("api_key",apiKey).
                build();

        return requestSpecification;
    }
}
