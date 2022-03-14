package io.scalaway.identity.data.sqlserver.repository;

import io.scalaway.identity.data.sqlserver.model.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountJpaRepository extends CrudRepository<AccountEntity, Long> {
}
