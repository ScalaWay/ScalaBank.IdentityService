package io.scalaway.identityservice.data.inmemory.repository;

import io.scalaway.identityservice.application.port.persistence.AccountRepository;
import io.scalaway.identityservice.data.inmemory.model.AccountDetails;
import io.scalaway.identityservice.domain.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InMemoryAccountRepository implements AccountRepository, UserDetailsService {

    private Map<String, Account> accountMap = new HashMap<>();

    @Override
    public Account createAccount(Account account) {
        accountMap.put(account.getEmail(), account);
        return account;
    }

    @Override
    public Account login(String email, String password) {
        return (Account) this.loadUserByUsername(email);
    }

    @Override
    public Account getByEmail(String email) {
        return this.accountMap.get(email);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = this.getByEmail(username);
        if (account != null){
            return new AccountDetails(account);
        }

        throw new UsernameNotFoundException(
                "User '" + username + "' not found");
    }
}
