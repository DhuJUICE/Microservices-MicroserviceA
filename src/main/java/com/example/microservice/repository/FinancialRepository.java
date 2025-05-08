package com.example.microservice.repository;

import com.example.microservice.model.Financial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FinancialRepository extends JpaRepository<Financial, Long> {
    Optional<Financial> findByUserId(Long userId);
}
