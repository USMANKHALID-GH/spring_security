package com.example.spring_security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResgisterRequest extends BaseDto{
    private String userName;
    private String userEmail;
    private String password;


}
