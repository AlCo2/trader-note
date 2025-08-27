package com.tradernote.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    String username;
    String email;
    String password;
    String confirmPassword;
}
