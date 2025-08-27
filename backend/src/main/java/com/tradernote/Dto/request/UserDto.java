package com.tradernote.Dto.request;

import com.tradernote.validation.annotation.UniqueEmail;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {

    @NotBlank(message = "username can't be empty.")
    private String username;

    @NotBlank
    @Email(message = "value must be a valid email")
    @UniqueEmail
    private String email;
    
    @NotBlank(message = "Password can't be empty.")
    private String password;
}
