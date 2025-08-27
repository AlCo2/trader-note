package com.tradernote.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.tradernote.Model.User;
import com.tradernote.Repository.RoleRepository;
import com.tradernote.Repository.UserRepository;

@Component
public class UserSeeder {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    RoleRepository roleRepository;


    public void run() {
        if (userRepository.count() == 0) { 
            System.out.println("seeding users...");
            User admin = new User();
            admin.setEmail("admin@gmail.com");
            admin.setUsername("admin");
            admin.setPassword(passwordEncoder.encode("adminadmin"));
            admin.getRoles().add(roleRepository.findByName("ROLE_admin"));
            userRepository.save(admin);
        }
    }
}
