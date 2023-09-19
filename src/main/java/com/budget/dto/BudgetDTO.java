package com.budget.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BudgetDTO {
    private Long id;
    private Double amount;
}
