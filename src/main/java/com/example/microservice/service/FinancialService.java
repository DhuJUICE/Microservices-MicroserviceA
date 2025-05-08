package com.example.microservice.service;

import com.example.microservice.model.Financial;
import com.example.microservice.repository.FinancialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FinancialService {

    @Autowired
    private FinancialRepository financialRepository;

    public List<Financial> getAllFinancials() {
        return financialRepository.findAll();
    }

    public List<Financial> getFinancialsByUserId(Long userId) {
        // Kept for legacy use if needed elsewhere
        return financialRepository.findAll().stream()
                .filter(f -> f.getUser().getId().equals(userId))
                .toList();
    }

    public Financial createFinancial(Financial financial) {
        return financialRepository.save(financial);
    }

    public Financial updateFinancial(Long id, Financial financial) {
        financial.setId(id);
        return financialRepository.save(financial);
    }

    public Financial updateFinancialByUserId(Long userId, Financial updatedFinancialData) {
        Optional<Financial> optionalFinancial = financialRepository.findByUserId(userId);

        if (optionalFinancial.isPresent()) {
            Financial existingFinancial = optionalFinancial.get();
            existingFinancial.setBankBalance(updatedFinancialData.getBankBalance());
            return financialRepository.save(existingFinancial);
        } else {
            throw new RuntimeException("Financial record not found for user ID: " + userId);
        }
    }

    public void deleteFinancial(Long id) {
        financialRepository.deleteById(id);
    }
}
