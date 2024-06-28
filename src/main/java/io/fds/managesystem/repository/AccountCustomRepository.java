package io.fds.managesystem.repository;

import io.fds.managesystem.entity.Account;

import java.util.Optional;

public interface AccountCustomRepository {

    public Optional<Account> findAccountByUserIdInAppAndAppId(String userIdInApp, String appId);
    public Account findAccountByUserIdAndUserIdInAppAndAppId(String userId, String userIdInApp, String appName);
}
