package io.scalaway.identityservice.application.usecase.authentication;

import io.scalaway.identityservice.application.usecase.authentication.command.LoginCommand;
import io.scalaway.identityservice.domain.Account;

public interface LoginUseCase {
    Account login(LoginCommand loginCommand);

}
