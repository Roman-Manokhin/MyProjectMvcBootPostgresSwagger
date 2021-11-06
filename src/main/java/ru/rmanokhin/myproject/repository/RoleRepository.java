package ru.rmanokhin.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.rmanokhin.myproject.entity.roles.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}