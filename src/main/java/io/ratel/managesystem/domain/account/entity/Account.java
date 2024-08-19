package io.ratel.managesystem.domain.account.entity;

import io.ratel.managesystem.common.entity.AuditableFields;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "ACCOUNT")
@Getter
public class Account extends AuditableFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Setter
    @Column(name = "USER_ID", nullable = false) private String userId;

    @Setter
    @Column(name = "APP_USER_ID", nullable = false) private String appUserId;

    @Setter
    @Column(name = "APP_NAME", nullable = false) private String appName;

    @Setter
    @Column(name = "PASSWORD", nullable = false) private String password;

    protected Account(){};

    private Account(String userId, String appUserId, String appName, String password) {
        this.userId = userId;
        this.appUserId = appUserId;
        this.appName = appName;
        this.password = password;
    }

    public static Account of(String userId,String userIdInApp,String appName,String password){
        return new Account(userId,userIdInApp,appName,password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(userId, account.userId) && Objects.equals(appUserId, account.appUserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, appUserId);
    }
}
