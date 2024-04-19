package com.alibou.security.spending;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/spending")
@RequiredArgsConstructor
public class SpendingController {
    private final SpendingService service;
    @GetMapping()
    List<Spending> getAllByUser(Principal principal){
        return service.getAllByUser(principal);
    }

    @PostMapping()
    void createSpending(@RequestBody Spending spending, Principal principal){
        service.createSpendingByUser(spending, principal);
    }

    @PostMapping("/update/{id}")
    void updateSpending(@RequestBody Spending spending, @PathVariable(value = "id") Integer id, Principal principal){
        service.createSpendingByUser(spending, principal);
    }

    @DeleteMapping("/{id}")
    void deleteSpending( @PathVariable(value = "id") Integer id){
        service.deleteSpending(id);
    }

    @GetMapping("/status")
    List<SpendingStatus> getStatus(){
        return service.getAllSpendingStatus();
    }

    @GetMapping("/type")
    List<SpendingType> getTypes(){
        return service.getAllSpendingType();
    }

    @GetMapping("/money")
    List<MoneyType> getMoneyTypes(){
        return service.getAllMoneyType();
    }

    @GetMapping("/type-status")
    List<SpendingTypeStatus> getTypeStatus(){
        return service.getAllSpendingTypeStatus();
    }
}
