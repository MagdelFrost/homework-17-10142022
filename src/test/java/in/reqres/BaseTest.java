package in.reqres;

import in.reqres.components.TestData;
import in.reqres.model.BodyModel;

public class BaseTest {

    TestData testData = new TestData();

    BodyModel registration = new BodyModel(testData.email, testData.password);
    BodyModel registrationWrong = new BodyModel(testData.emailWrong, testData.passwordWrong);
}
