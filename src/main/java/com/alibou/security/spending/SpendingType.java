package com.alibou.security.spending;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SpendingType {
    @Id
    @GeneratedValue
    public Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "spendingTypeStatus_id")
    public SpendingTypeStatus spendingTypeStatus;

    @JsonIgnore
    @OneToMany(mappedBy = "spendingType")
    private List<Spending> spendings;

    @Column(unique = true)
    public String name;
}
