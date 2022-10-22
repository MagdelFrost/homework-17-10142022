package in.reqres.components;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Locale;

@Getter
@NoArgsConstructor
public class TestData {

    public static final String BASE_URL = "https://reqres.in/";

    FakeValuesService fakeValuesService = new FakeValuesService(
            new Locale("en-GB"), new RandomService());

    private String emailWrong = fakeValuesService.bothify("????##@reqres.in");

    private String passwordWrong = fakeValuesService.regexify("[a-z1-9]{10}");

    private String email = "eve.holt@reqres.in";

    private String password = "123456789";
}
