package com.tradernote.Dto.request;

import com.tradernote.validation.annotation.UniqueEmailUpdate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@UniqueEmailUpdate
@Getter
@Setter
public class UserUpdateDto {
    
    @NotNull
    private Long id;

    @NotBlank(message = "username can't be empty.")
    private String username;

    @NotBlank
    @Email(message = "value must be a valid email")
    private String email;

    private String password;
}
