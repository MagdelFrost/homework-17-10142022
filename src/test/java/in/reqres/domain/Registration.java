package in.reqres.domain;

import lombok.*;

//@Getter
//@Setter
//@AllArgsConstructor хотел подключить lombok но без явных сеттеров геттеров jackson не работал, а AllArgsConstructor и вовсе выдавал ошибку
public class Registration {
    private String email;
    private String password;

    public Registration(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
