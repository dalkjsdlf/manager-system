package io.ratel.managesystem.domain.account.repository;

import io.ratel.managesystem.domain.account.entity.Account;
import io.ratel.managesystem.domain.account.repository.AccountCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long>, AccountCustomRepository {

}
