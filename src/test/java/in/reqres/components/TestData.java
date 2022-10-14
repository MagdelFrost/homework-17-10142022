package in.reqres.components;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import lombok.NoArgsConstructor;

import java.util.Locale;

@NoArgsConstructor
public class TestData {

    public final String BASE_URL = "https://reqres.in/";

    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());

    public String emailWrong = fakeValuesService.bothify("????##@reqres.in");

    public String passwordWrong = fakeValuesService.regexify("[a-z1-9]{10}");

    public String email = "eve.holt@reqres.in";

    public String password = "123";
}
