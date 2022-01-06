package io.scalaway.identityservice.api.dto;

import io.scalaway.identityservice.domain.Account;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class AccountProfileOutput {
    private String firstName;
    private String lastName;
    private String email;
    private String token;

    public static AccountProfileOutput fromDomain(Account account){
        AccountProfileOutput accountProfileOutput = new AccountProfileOutput();
        accountProfileOutput.setEmail(account.getEmail());
        accountProfileOutput.setFirstName(account.getFirstName());
        accountProfileOutput.setLastName(account.getLastName());
        return accountProfileOutput;
    }

    public AccountProfileOutput updateToken(String token){
        setToken(token);
        return this;
    }
}
