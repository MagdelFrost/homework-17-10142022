package in.reqres.specs;

import in.reqres.components.TestData;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static in.reqres.helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.notNullValue;

public class FullSpecs {
    public static RequestSpecification connectionRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri(TestData.BASE_URL)
            .basePath("api/users?page=2")
            .log().uri()
            .log().body()
            .contentType(JSON);

    public static RequestSpecification loginRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri(TestData.BASE_URL)
            .basePath("api/login")
            .log().uri()
            .log().body()
            .contentType(JSON);

    public static RequestSpecification registrationRequestSpec = with()
            .filter(withCustomTemplates())
            .baseUri(TestData.BASE_URL)
            .basePath("api/register")
            .log().uri()
            .log().body()
            .contentType(JSON);

    public static ResponseSpecification positiveResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.STATUS)
            .log(LogDetail.BODY)
            .expectBody("token", notNullValue())
            .build();

    public static ResponseSpecification negativeResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(400)
            .log(LogDetail.BODY)
            .build();

    public static ResponseSpecification connectionResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(LogDetail.BODY)
            .build();
}
