package com.budget.service;

import com.budget.dto.BudgetDTO;

public interface BudgetService {
    BudgetDTO create(BudgetDTO dto);
    BudgetDTO update(BudgetDTO dto);
    BudgetDTO getByUserId(Long userId);
}
