package com.jobhub.config;

import com.jobhub.entity.Role;
import com.jobhub.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleSeeder implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public RoleSeeder(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {

        if (roleRepository.count() == 0) {

            roleRepository.save(
                    new Role("ADMIN", "System Administrator"));

            roleRepository.save(
                    new Role("RECRUITER", "Recruiter"));

            roleRepository.save(
                    new Role("JOB_SEEKER", "Job Seeker"));

            System.out.println("Roles seeded successfully");
        }
    }
}