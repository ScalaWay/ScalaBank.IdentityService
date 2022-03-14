package io.scalaway.identity.application.usecase.authentication.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class LoginCommand {
    private String email;
    private String password;
}
