package com.alibou.security.balance;

import com.alibou.security.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Balance {
    @EmbeddedId
    private BalanceId id;

    @ManyToOne
    @JoinColumn(name = "balance_type_id", referencedColumnName = "id", insertable = false, updatable = false)
    private BalanceType balanceType;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    private User user;

    @Column(unique = true)
    public String name;
}
