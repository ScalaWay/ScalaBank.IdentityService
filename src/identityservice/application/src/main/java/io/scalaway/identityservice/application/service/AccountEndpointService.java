package io.scalaway.identityservice.application.service;

import io.scalaway.identityservice.application.port.api.AccountEndpoint;
import io.scalaway.identityservice.application.port.persistence.AccountRepository;

public class AccountEndpointService implements AccountEndpoint {

    private final AccountRepository accountRepository;

    public AccountEndpointService(
            AccountRepository accountRepository
    ){
        this.accountRepository = accountRepository;
    }

}
