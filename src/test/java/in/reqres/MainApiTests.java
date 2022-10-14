package in.reqres;

import org.junit.jupiter.api.Test;

import static groovy.json.JsonOutput.toJson;
import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;

public class MainApiTests extends BaseTest{

    @Test
    public void connectionTest() {
        given()
                .log().uri()
                .log().body()
                .contentType(JSON)
                   .when()
                .get(testData.BASE_URL + "api/users?page=2")
                   .then()
                .statusCode(200);
    }

    @Test
    public void registrationPositiveTest() {
        given()
                .log().uri()
                .log().body()
                .contentType(JSON)
                .body(toJson(registration))
                   .when()
                .post(testData.BASE_URL + "api/register")
                   .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    public void loginPositiveTest() {
        given()
                .log().uri()
                .log().body()
                .contentType(JSON)
                .body(toJson(registration))
                   .when()
                .post(testData.BASE_URL + "api/login")
                   .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("token", is("QpwL5tke4Pnpja7X4"));
    }

    @Test
    public void registrationNegativeTest() {
        given()
                .log().uri()
                .log().body()
                .contentType(JSON)
                .body(toJson(registrationWrong))
                  .when()
                .post(testData.BASE_URL + "api/register")
                  .then()
                .log().status()
                .log().body()
                .statusCode(400);
    }

    @Test
    public void loginNegativeTest() {
        given()
                .log().uri()
                .log().body()
                .contentType(JSON)
                .body(toJson(registrationWrong))
                  .when()
                .post(testData.BASE_URL + "api/login")
                  .then()
                .log().status()
                .log().body()
                .statusCode(400);
    }
}
