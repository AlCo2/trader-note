package com.tradernote.validation.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tradernote.Dto.request.UserUpdateDto;
import com.tradernote.Model.User;
import com.tradernote.Repository.UserRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


@Component
public class UniqueEmailUpdateValidator implements ConstraintValidator<com.tradernote.validation.annotation.UniqueEmailUpdate, UserUpdateDto> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValid(UserUpdateDto userDto, ConstraintValidatorContext context) {
        String email = userDto.getEmail();
        Long id = userDto.getId();

        if (email == null || id == null) {
            return true;
        }
        
        if (userRepository.existsByEmail(email)){
            User user = userRepository.findByEmail(email);
            return user.getId() == id;
        }
        
        return true;
    }
    
}
