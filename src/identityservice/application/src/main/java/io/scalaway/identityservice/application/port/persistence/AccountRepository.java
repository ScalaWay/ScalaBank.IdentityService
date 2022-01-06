package io.scalaway.identityservice.application.port.persistence;

import io.scalaway.identityservice.domain.Account;

public interface AccountRepository {

    Account createAccount(Account account);

    Account login(String email, String password);

    Account getByEmail(String email);
}
