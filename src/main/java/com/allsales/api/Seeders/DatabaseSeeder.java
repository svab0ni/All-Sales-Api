package com.allsales.api.Seeders;

import com.allsales.api.Models.Role;
import com.allsales.api.Models.RoleName;
import com.allsales.api.Models.User;
import com.allsales.api.Repositories.UserRepository;
import com.allsales.api.security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public DatabaseSeeder(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedRolesTable();
        seedUsersTable();
    }

    private void seedRolesTable() {
        Role role1 = new Role();

        role1.setName(RoleName.ROLE_SUPER_ADMIN);
        roleRepository.save(role1);

        Role role2 = new Role();
        role2.setName(RoleName.ROLE_ADMIN);
        roleRepository.save(role2);

        Role role3 = new Role();
        role3.setName(RoleName.ROLE_USER);
        roleRepository.save(role3);
    }

    private void seedUsersTable() {
            List<Role> roles = new ArrayList<Role>();
            Role role = roleRepository.findByName(RoleName.ROLE_SUPER_ADMIN);
            roles.add(role);

            User user = new User();
            user.setFirstname("Spring Blog");
            user.setLastname("dsaad");
            user.setUsername("admin");
            user.setEmail("test@test.com");
            user.setPassword("test123");
            user.setRoles(roles);
            user.setEnabled(true);
            userRepository.save(user);
    }

}
