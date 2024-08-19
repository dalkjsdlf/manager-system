package io.ratel.managesystem.domain.account.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import io.ratel.managesystem.domain.account.entity.Account;
import io.ratel.managesystem.domain.account.repository.AccountCustomRepository;

import java.util.Optional;

import static io.ratel.managesystem.domain.account.entity.QAccount.account;

public class AccountCustomRepositoryImpl implements AccountCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public AccountCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public Optional<Account> findAccountByUserIdInAppAndAppId(String userIdInApp, String appId) {

        return Optional.empty();
    }

    @Override
    public Account findAccountByUserIdAndAppUserIdAndAppName(String userId,
                                                             String userIdInApp,
                                                             String appName) {
        return jpaQueryFactory.
                selectFrom(account).
                where(account.userId.eq(userId),
                        account.appName.eq(String.valueOf(appName)),
                        account.appUserId.eq(userIdInApp)).fetchFirst();

    }
}
