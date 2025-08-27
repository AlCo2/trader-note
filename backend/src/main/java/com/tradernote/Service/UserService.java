package com.tradernote.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.tradernote.Compoenent.CustomUserDetails;
import com.tradernote.Dto.request.UserDto;
import com.tradernote.Dto.request.UserUpdateDto;
import com.tradernote.Dto.response.UserResponseDto;
import com.tradernote.Exception.SelfDeletionNotAllowedException;
import com.tradernote.Model.User;
import com.tradernote.Repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::convertToResponseDto).collect(Collectors.toList());
    }
    
    public UserResponseDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return convertToResponseDto(user);
    }

    public UserResponseDto updateUserById(Long id, UserUpdateDto userDto) {
        User user = userRepository.findById(id).orElseThrow();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        
        if (userDto.getPassword() != null && !userDto.getPassword().isBlank()) {
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }

        userRepository.save(user);
        
        return convertToResponseDto(user);
    }

    public UserResponseDto saveUser(UserDto userDto) {
        User user = convertToEntity(userDto);
        return convertToResponseDto(userRepository.save(user));
    }

    public User convertToEntity(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return user;
    }

    public UserResponseDto convertToResponseDto(User user) {
        UserResponseDto userDto = new UserResponseDto();
        userDto.setId(user.getId());
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        return userDto;
    }

    public void deleteUserById(Long id) {
        Long userId = getCurrentUserId();
        
        if (userId == id) {
            throw new SelfDeletionNotAllowedException("you can't delete your own account.");
        }

        userRepository.deleteById(id);
    }

    private Long getCurrentUserId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !(auth.getPrincipal() instanceof CustomUserDetails)) {
            throw new AuthorizationDeniedException("User not authenticated or invalid user details.");
        }

        return ((CustomUserDetails) auth.getPrincipal()).getId();
    }

}
