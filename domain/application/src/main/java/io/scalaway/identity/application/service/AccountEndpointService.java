package io.scalaway.identity.application.service;

import io.scalaway.identity.application.port.api.AccountEndpoint;
import io.scalaway.identity.application.port.persistence.AccountRepository;

public class AccountEndpointService implements AccountEndpoint {

    private final AccountRepository accountRepository;

    public AccountEndpointService(
            AccountRepository accountRepository
    ){
        this.accountRepository = accountRepository;
    }

}
