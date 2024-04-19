package com.alibou.security.balance;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BalanceId implements Serializable {
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "balance_type_id")
    private Integer balanceType;
}
