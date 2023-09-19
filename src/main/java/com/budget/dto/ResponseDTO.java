package com.budget.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDTO <T extends Object>{
    private String code;
    private String message;
    private T content;

    public static final String CODE_SUCCESS = "00";
    public static final String CODE_ERROR = "500";
    public static final String MESSAGE_SUCCESS = "Successful operation";
    public static final String MESSAGE_ERROR = "Failed in the operation";
}
