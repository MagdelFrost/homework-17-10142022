package in.reqres.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.reqres.domain.Registration;

public class JsonGenerator {

    public String toJson(Registration registration) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(registration);
    }

}
