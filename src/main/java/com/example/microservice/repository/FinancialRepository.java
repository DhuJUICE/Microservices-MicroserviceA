package com.example.microservice.repository;

import com.example.microservice.model.Financial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinancialRepository extends JpaRepository<Financial, Long> {
    List<Financial> findByUserId(Long userId);
}
