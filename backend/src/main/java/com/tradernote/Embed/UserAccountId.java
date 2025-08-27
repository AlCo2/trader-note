package com.tradernote.Embed;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserAccountId implements Serializable {
    
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "account_id")
    private Long accountId;

}
