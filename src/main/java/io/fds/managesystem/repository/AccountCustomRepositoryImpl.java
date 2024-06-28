package io.fds.managesystem.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.fds.managesystem.entity.Account;

import java.util.Optional;

import static io.fds.managesystem.entity.QAccount.account;

public class AccountCustomRepositoryImpl implements AccountCustomRepository{
    private final JPAQueryFactory jpaQueryFactory;

    public AccountCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Optional<Account> findAccountByUserIdInAppAndAppId(String userIdInApp, String appId) {

        return Optional.empty();
    }

    @Override
    public Account findAccountByUserIdAndUserIdInAppAndAppId(String userId,
                                                                       String userIdInApp,
                                                                       String appName) {
        return jpaQueryFactory.
                selectFrom(account).
                where(account.userId.eq(userId),
                        account.appName.eq(String.valueOf(appName)),
                        account.userIdInApp.eq(userIdInApp)).fetchFirst();

    }
}
