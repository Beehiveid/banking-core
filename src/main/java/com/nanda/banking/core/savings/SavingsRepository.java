package com.nanda.banking.core.savings;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SavingsRepository extends JpaRepository<Savings, UUID> {
}
