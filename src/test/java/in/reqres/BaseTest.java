package in.reqres;

import in.reqres.components.TestData;
import in.reqres.model.BodyModel;

public class BaseTest {

    TestData testData = new TestData();

    BodyModel body = new BodyModel(testData.getEmail(), testData.getPassword());
    BodyModel bodyWrong = new BodyModel(testData.getEmailWrong(), testData.getPasswordWrong());
}
