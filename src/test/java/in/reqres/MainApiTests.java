package in.reqres;

import in.reqres.model.ResponseModel;
import in.reqres.specs.FullSpecs;
import org.junit.jupiter.api.Test;

import static in.reqres.specs.FullSpecs.*;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;

public class MainApiTests extends BaseTest {

    @Test
    public void connectionTest() {
        given()
                .spec(FullSpecs.connectionRequestSpec)
                .when()
                .get()
                .then()
                .body("data.findAll{it.email =~/.*?@reqres.in/}.email.flatten()",
                        hasItem(testData.getEmail()))
                .spec(connectionResponseSpec);
    }

    @Test
    public void registrationPositiveTest() {
        ResponseModel response = given()
                .spec(FullSpecs.registrationRequestSpec)
                .body(body)
                .when()
                .post()
                .then()
                .spec(positiveResponseSpec)
                .extract()
                .as(ResponseModel.class);

        assertThat(response.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
    }

    @Test
    public void loginPositiveTest() {
        ResponseModel response = given()
                .spec(FullSpecs.loginRequestSpec)
                .body(body)
                .when()
                .post()
                .then()
                .spec(positiveResponseSpec)
                .extract()
                .as(ResponseModel.class);

        assertThat(response.getToken()).isEqualTo("QpwL5tke4Pnpja7X4");
    }

    @Test
    public void registrationNegativeTest() {
        given()
                .spec(FullSpecs.registrationRequestSpec)
                .body(bodyWrong)
                .when()
                .post()
                .then()
                .spec(negativeResponseSpec)
                .extract()
                .as(ResponseModel.class);
    }

    @Test
    public void loginNegativeTest() {
        given()
                .spec(FullSpecs.loginRequestSpec)
                .body(bodyWrong)
                .when()
                .post()
                .then()
                .spec(negativeResponseSpec)
                .extract()
                .as(ResponseModel.class);
    }
}
