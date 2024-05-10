package org.scaler.bms5thmay.dto;


import lombok.Data;

@Data
public class SignupRequestDto {
    private String name;
    private String email;

    private String Password;
}
