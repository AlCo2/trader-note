package com.tradernote.seeder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeed implements CommandLineRunner {
    @Autowired
    RoleSeeder roleSeeder;
    @Autowired
    UserSeeder userSeeder;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running Data Seeder...");
        roleSeeder.run();
        userSeeder.run();
    }
}
