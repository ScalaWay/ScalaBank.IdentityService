package io.scalaway.identityservice.data.sqlserver.repositories;

import io.scalaway.identityservice.data.sqlserver.models.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountJpaRepository extends CrudRepository<AccountEntity, Long> {
}
