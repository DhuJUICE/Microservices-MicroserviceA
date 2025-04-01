package com.example.microservice.service;

import com.example.microservice.model.Financial;
import com.example.microservice.repository.FinancialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialService {

    @Autowired
    private FinancialRepository financialRepository;

    public List<Financial> getFinancialsByUserId(Long userId) {
        return financialRepository.findByUserId(userId);
    }

    public Financial createFinancial(Financial financial) {
        return financialRepository.save(financial);
    }

    public Financial updateFinancial(Long id, Financial financial) {
        financial.setId(id);
        return financialRepository.save(financial);
    }

    public void deleteFinancial(Long id) {
        financialRepository.deleteById(id);
    }
}
