package com.alibou.security.spending;

import com.alibou.security.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Spending {
    @Id
    @GeneratedValue
    public Integer id;
    public Long amount;
    @Column(columnDefinition = "TIMESTAMP")
    public LocalDateTime createTime;
    public String description;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    public User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "moneyType_id")
    public MoneyType moneyType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spendingType_id")
    public SpendingType spendingType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spendingStatus_id")
    public SpendingStatus spendingStatus;
}
