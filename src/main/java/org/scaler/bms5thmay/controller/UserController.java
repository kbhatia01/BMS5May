package org.scaler.bms5thmay.controller;

import org.scaler.bms5thmay.Service.UserService;
import org.scaler.bms5thmay.dto.*;
import org.scaler.bms5thmay.models.User;
import org.springframework.stereotype.Controller;


@Controller
public class UserController {

    private UserService userService;

   public UserController(UserService userService){
        this.userService = userService;
    }

    public SignupResponseDto signup(SignupRequestDto requestDto){

       User u = this.userService.signup(requestDto.getEmail(), requestDto.getPassword(), requestDto.getName());

       SignupResponseDto signupResponseDto = new SignupResponseDto();

       signupResponseDto.setUserId(u.getId());
       signupResponseDto.setStatus(ResponseStatus.SUCCESS);
       return signupResponseDto;
    }

    public LoginResponseDto login(LoginRequestDto loginRequestDto){
        LoginResponseDto loginResponseDto = new LoginResponseDto();

       try{
           this.userService.login(loginRequestDto.getEmail(), loginRequestDto.getPassword());
           loginResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
       } catch (Exception e){
           loginResponseDto.setResponseStatus(ResponseStatus.FAILURE);
       }


       return loginResponseDto;

    }

}
