package io.fds.managesystem.domain.account.repository;

import io.fds.managesystem.domain.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long>, AccountCustomRepository{

}
