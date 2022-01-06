package io.scalaway.identityservice.data.sqlserver.repositories;
import io.scalaway.identityservice.application.port.persistence.AccountRepository;
import io.scalaway.identityservice.data.sqlserver.models.AccountEntity;
import io.scalaway.identityservice.domain.Account;
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
