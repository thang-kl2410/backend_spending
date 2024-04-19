package com.alibou.security.balance;

import com.alibou.security.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BalanceRepository extends JpaRepository<Balance, BalanceId> {
    List<Balance> findAllByUser(User user);
}
