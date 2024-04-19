package com.alibou.security.spending;

import com.alibou.security.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpendingService {
    private final SpendingRepository repository;
    private final MoneyTypeRepository moneyTypeRepository;
    private final SpendingStatusRepository spendingStatusRepository;
    private final SpendingTypeRepository spendingTypeRepository;
    private final SpendingTypeStatusRepository spendingTypeStatusRepository;

    void createSpendingByUser(Spending spending, Principal principal){
        var user = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        Spending s = spending;
        s.setUser(user);
        repository.save(s);
    }

    void updateSpending(Spending spending){
        repository.save(spending);
    }

    void deleteSpending(Integer id){
        repository.deleteById(id);
    }

    List<Spending> getAllByUser(Principal principal){
        return List.of();
    }

    List<MoneyType> getAllMoneyType(){
        return moneyTypeRepository.findAll();
    }

    List<SpendingStatus> getAllSpendingStatus(){
        return spendingStatusRepository.findAll();
    }

    List<SpendingType> getAllSpendingType(){
        return spendingTypeRepository.findAll();
    }

    List<SpendingTypeStatus> getAllSpendingTypeStatus(){
        return spendingTypeStatusRepository.findAll();
    }
}
