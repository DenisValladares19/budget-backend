package com.budget.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDTOWithToken extends UserDTO {
    private String token;
}
