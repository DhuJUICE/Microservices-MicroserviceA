package com.example.microservice.controller;

import com.example.microservice.model.Financial;
import com.example.microservice.service.FinancialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/financials")
public class FinancialController {

    @Autowired
    private FinancialService financialService;

    @GetMapping
    public List<Financial> getAllFinancials() {
        return financialService.getAllFinancials();
    }

    @GetMapping("/user/{userId}")
    public List<Financial> getFinancialsByUserId(@PathVariable Long userId) {
        return financialService.getFinancialsByUserId(userId);
    }

    @PostMapping
    public Financial createFinancial(@RequestBody Financial financial) {
        return financialService.createFinancial(financial);
    }

    @PutMapping("/{id}")
    public Financial updateFinancial(@PathVariable Long id, @RequestBody Financial financial) {
        return financialService.updateFinancial(id, financial);
    }

    @PutMapping("/user/{userId}")
    public Financial updateFinancialByUserId(@PathVariable Long userId, @RequestBody Financial financial) {
        return financialService.updateFinancialByUserId(userId, financial);
    }

    @DeleteMapping("/{id}")
    public void deleteFinancial(@PathVariable Long id) {
        financialService.deleteFinancial(id);
    }
}
