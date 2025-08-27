package com.tradernote.Model;

import org.springframework.security.core.userdetails.User;

import com.tradernote.Embed.UserAccountId;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_account")
public class UserAccount {

    @EmbeddedId
    private UserAccountId id = new UserAccountId();

    // @ManyToOne
    // @MapsId("userId")
    // @JoinColumn(name = "user_id")
    // private User user;

    // @ManyToOne
    // @MapsId("accountId")
    // @JoinColumn(name = "account_id")
    // private Account account;
}
