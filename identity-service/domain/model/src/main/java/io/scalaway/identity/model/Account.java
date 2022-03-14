package io.scalaway.identity.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Base64;

@Getter
@Setter
public class Account {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;

    public String getAuthorizationBase64(){
        return Base64
                .getEncoder()
                .withoutPadding()
                .encodeToString(String.join(":", this.email, this.password).getBytes());
    }
}
