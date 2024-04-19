package com.alibou.security.balance;

import com.alibou.security.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BalanceService {
    private final BalanceRepository repository;

    public List<Balance> getAllByUser(Principal principal){
        var user = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        return repository.findAllByUser(user);
    }

}
