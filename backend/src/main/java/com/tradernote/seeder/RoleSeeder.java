package com.tradernote.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tradernote.Model.Role;
import com.tradernote.Repository.RoleRepository;

@Component
public class RoleSeeder{
    @Autowired
    RoleRepository roleRepository;

    public void run() {
        if (roleRepository.count() == 0 ) {
            System.out.println("seeding roles...");
            Role admin = new Role();
            admin.setName("ROLE_admin");
            roleRepository.save(admin);
        }
    }
}
