package ru.rmanokhin.myproject.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private String email;
    private String password;
    private String name;
    private String surname;
    private Integer age;
    private String sex;
    private Set<RoleDTO> roles;

}
