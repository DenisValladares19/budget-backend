package com.budget.service;

import com.budget.dto.RechargeBalanceDTO;

import java.util.List;

public interface RechargeBalanceService {
    List<RechargeBalanceDTO> getAll(Long userId);
    RechargeBalanceDTO create(RechargeBalanceDTO dto);
    void delete(Long rechargeId);
}
