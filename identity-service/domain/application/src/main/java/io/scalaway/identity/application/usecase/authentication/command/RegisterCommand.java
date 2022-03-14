package io.scalaway.identity.application.usecase.authentication.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class RegisterCommand {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String confirmPassword;
}
