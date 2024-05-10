package org.scaler.bms5thmay.dto;


import lombok.Data;

@Data
public class SignupResponseDto {

    private Long userId;

    private ResponseStatus status;
}
