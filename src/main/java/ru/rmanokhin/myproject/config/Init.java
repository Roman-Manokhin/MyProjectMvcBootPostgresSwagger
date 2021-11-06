package ru.rmanokhin.myproject.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import ru.rmanokhin.myproject.entity.roles.Role;
import ru.rmanokhin.myproject.service.RoleService;

import javax.annotation.PostConstruct;

@Configuration
@RequiredArgsConstructor
public class Init {


    private final RoleService roleService;

    @PostConstruct
    private void itit(){

        Role role = new Role();
        role.setName("user");
        Role role1 = new Role();
        role1.setName("admin");
        roleService.saveRole(role);
        roleService.saveRole(role1);
    }
}
