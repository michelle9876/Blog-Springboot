package com.springboot.blog.data.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserRequestDto {
    private String name;
    private String email;
    private String password;
    private String rePassword;

}
