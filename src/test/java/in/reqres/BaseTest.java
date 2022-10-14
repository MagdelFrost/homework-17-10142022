package in.reqres;

import in.reqres.components.TestData;
import in.reqres.domain.Registration;

public class BaseTest {

    TestData testData = new TestData();

    Registration registration = new Registration(testData.email, testData.password);
    Registration registrationWrong = new Registration(testData.emailWrong, testData.passwordWrong);
}
