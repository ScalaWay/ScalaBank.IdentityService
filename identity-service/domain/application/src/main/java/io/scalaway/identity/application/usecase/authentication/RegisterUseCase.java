package io.scalaway.identity.application.usecase.authentication;

import io.scalaway.identity.application.usecase.authentication.command.RegisterCommand;
import io.scalaway.identity.model.Account;

public interface RegisterUseCase {
    Account register(RegisterCommand registerCommand);
}
