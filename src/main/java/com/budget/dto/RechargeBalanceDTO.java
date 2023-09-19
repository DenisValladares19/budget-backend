package com.budget.dto;

import com.budget.enums.CompanyEnum;
import com.budget.enums.TypeRecharge;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RechargeBalanceDTO {
    private Long id;
    private MovementDTO movement;
    private CompanyEnum company;
    private TypeRecharge typeRecharge;
    private Double revenue;
}
