package io.scalaway.identity.application.usecase.authentication;

import io.scalaway.identity.application.usecase.authentication.command.LoginCommand;
import io.scalaway.identity.model.Account;

public interface LoginUseCase {
    Account login(LoginCommand loginCommand);

}
