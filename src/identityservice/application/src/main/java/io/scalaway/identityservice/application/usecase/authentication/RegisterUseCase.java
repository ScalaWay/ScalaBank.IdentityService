package io.scalaway.identityservice.application.usecase.authentication;

import io.scalaway.identityservice.application.usecase.authentication.command.RegisterCommand;
import io.scalaway.identityservice.domain.Account;

public interface RegisterUseCase {
    Account register(RegisterCommand registerCommand);
}
