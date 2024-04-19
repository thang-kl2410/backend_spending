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
public class MoneyType {
    @Id
    @GeneratedValue
    public Integer id;

    @Column(unique = true)
    public String name;

    @JsonIgnore
    @OneToMany(mappedBy = "moneyType")
    private List<Spending> spendings;
}
