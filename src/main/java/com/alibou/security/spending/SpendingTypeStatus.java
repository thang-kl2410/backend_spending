package com.alibou.security.spending;

import com.alibou.security.token.Token;
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
public class SpendingTypeStatus {
    @Id
    @GeneratedValue
    public Integer id;

    @Column(unique = true)
    public String name;

    @JsonIgnore
    @OneToMany(mappedBy = "spendingTypeStatus")
    private List<SpendingType> spendingTypes;
}
