package io.fds.managesystem.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table
@Getter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Setter
    @Column(nullable = false) private String userId;

    @Setter
    @Column(nullable = false) private String userIdInApp;

    @Setter
    @Column(nullable = false) private String appName;

    @Setter
    @Column(nullable = false) private String password;

    protected Account(){};

    private Account(String userId, String userIdInApp, String appName, String password) {
        this.userId = userId;
        this.userIdInApp = userIdInApp;
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
        return Objects.equals(userId, account.userId) && Objects.equals(userIdInApp, account.userIdInApp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userIdInApp);
    }
}
