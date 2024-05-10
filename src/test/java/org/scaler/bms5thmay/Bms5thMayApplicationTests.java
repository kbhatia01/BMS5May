package org.scaler.bms5thmay;

import org.junit.jupiter.api.Test;
import org.scaler.bms5thmay.controller.UserController;
import org.scaler.bms5thmay.dto.SignupRequestDto;
import org.scaler.bms5thmay.dto.SignupResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Bms5thMayApplicationTests {


    @Autowired
    private UserController userController;

    @Test
    void contextLoads() {
    }

    @Test
    public void testSignUpFunctionality() {
        SignupRequestDto requestDto = new SignupRequestDto();

        requestDto.setEmail("abcde@gmail.com");
        requestDto.setPassword("password");
        requestDto.setName("MNO");

        SignupResponseDto responseDto = userController.signup(requestDto);
        System.out.println("User id is: "+ responseDto.getUserId());

    }
}