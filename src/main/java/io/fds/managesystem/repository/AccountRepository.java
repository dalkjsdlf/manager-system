package io.fds.managesystem.repository;

import io.fds.managesystem.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long>, AccountCustomRepository{

}
