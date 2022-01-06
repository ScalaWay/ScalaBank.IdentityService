package io.scalaway.identityservice.application.service;

import io.scalaway.identityservice.application.port.api.AuthenticationEndpoint;
import io.scalaway.identityservice.application.port.persistence.AccountRepository;
import io.scalaway.identityservice.application.usecase.authentication.command.LoginCommand;
import io.scalaway.identityservice.application.usecase.authentication.command.RegisterCommand;
import io.scalaway.identityservice.domain.Account;

public class AuthenticationEndpointService implements AuthenticationEndpoint {

    private final AccountRepository accountRepository;

    public AuthenticationEndpointService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public Account register(RegisterCommand registerCommand) {
        Account account = new Account();
        account.setFirstName(registerCommand.getFirstName());
        account.setLastName(registerCommand.getLastName());
        account.setEmail(registerCommand.getEmail());
        account.setPassword(registerCommand.getPassword());
        return this.accountRepository.createAccount(account);
    }

    @Override
    public Account login(LoginCommand loginCommand) {
        return this.accountRepository.login(loginCommand.getEmail(), loginCommand.getPassword());
    }

    @Override
    public void logout() {

    }
}
