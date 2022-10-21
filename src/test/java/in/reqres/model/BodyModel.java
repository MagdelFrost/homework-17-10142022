package in.reqres.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BodyModel {
    private String email;
    private String password;
}
