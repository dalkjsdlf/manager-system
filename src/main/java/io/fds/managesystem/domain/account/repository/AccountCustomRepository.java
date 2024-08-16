package io.fds.managesystem.domain.account.repository;

import io.fds.managesystem.domain.account.entity.Account;

import java.util.Optional;

public interface AccountCustomRepository {

    public Optional<Account> findAccountByUserIdInAppAndAppId(String userIdInApp, String appId);
    public Account findAccountByUserIdAndAppUserIdAndAppName(String userId, String appUserId, String appName);
}
