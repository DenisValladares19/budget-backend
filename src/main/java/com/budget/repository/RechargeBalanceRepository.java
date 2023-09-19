package com.budget.repository;

import com.budget.entity.RechargeBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RechargeBalanceRepository extends JpaRepository<RechargeBalance, Long> {
}
