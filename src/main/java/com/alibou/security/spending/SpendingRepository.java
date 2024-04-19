package com.alibou.security.spending;

import com.alibou.security.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpendingRepository extends JpaRepository<Spending, Integer> {
    List<Spending> findAllByUser(User user);
}
