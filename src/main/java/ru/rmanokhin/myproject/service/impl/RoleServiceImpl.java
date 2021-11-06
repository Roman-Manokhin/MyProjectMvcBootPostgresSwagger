package ru.rmanokhin.myproject.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.rmanokhin.myproject.entity.roles.Role;
import ru.rmanokhin.myproject.repository.RoleRepository;
import ru.rmanokhin.myproject.service.RoleService;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role saveRole(Role role) {
        return roleRepository.save(role);
    }
}
