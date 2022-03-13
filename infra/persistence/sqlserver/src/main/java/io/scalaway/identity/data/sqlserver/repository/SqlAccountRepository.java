package io.scalaway.identity.data.sqlserver.repository;
import io.scalaway.identity.application.port.persistence.AccountRepository;
import io.scalaway.identity.data.sqlserver.model.AccountEntity;
import io.scalaway.identity.model.Account;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SqlAccountRepository implements AccountRepository {

    private AccountJpaRepository accountJpaRepository;

    @Override
    public Account createAccount(Account account) {
        AccountEntity accountEntity = new AccountEntity();
        BeanUtils.copyProperties(account, accountEntity);
        accountJpaRepository.save(accountEntity);
        BeanUtils.copyProperties(accountEntity, account);
        return account;
    }

    @Override
    public Account login(String email, String password) {
        return null;
    }

    @Override
    public Account getByEmail(String email) {
        return null;
    }
}
