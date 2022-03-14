package io.scalaway.identity.application.port.persistence;

import io.scalaway.identity.model.Account;

public interface AccountRepository {

    Account createAccount(Account account);

    Account login(String email, String password);

    Account getByEmail(String email);
}
