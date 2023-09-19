package com.budget.dto;
import com.budget.enums.TypeMovement;
import com.budget.enums.TypeTransaction;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MovementDTO {
    private Long id;
    private Double currentAmount;
    private Double amount;
    private TypeTransaction typeTransaction;
    private TypeMovement typeMovement;
    private String comment;
    private Date createdAt;
}
