package ru.rmanokhin.myproject.mappers;

import org.springframework.stereotype.Service;
import ru.rmanokhin.myproject.dto.PersonDTO;
import ru.rmanokhin.myproject.dto.RoleDTO;
import ru.rmanokhin.myproject.entity.enums.Gender;
import ru.rmanokhin.myproject.entity.persons.Person;
import ru.rmanokhin.myproject.entity.roles.Role;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MappingUtils {

//    public PersonDTO personToPersonDTO(Persona person) {
//        Set<RoleDTO> roleDTOS = rolesToRoleDTO(person.getRoles());
//
//        return PersonDTO.builder()
//                .id(person.getId())
//                .name(person.getName())
//                .surname(person.getSurname())
//                .age(person.getAge())
//                .sex(person.getSex().toString())
//                .email(person.getEmail())
//                .roles(roleDTOS)
//                .build();
//    }

    public Person PersonDTOToPersona(PersonDTO personDTO) {
        Gender gender = Gender.MALE.toString().equals(personDTO.getSex()) ? Gender.MALE : Gender.FEMALE;
        Set<Role> role = rolesToRoleDTO(personDTO.getRoles());

        return Person.builder()
                .email(personDTO.getEmail())
                .password(personDTO.getPassword())
                .name(personDTO.getName())
                .surname(personDTO.getSurname())
                .age(personDTO.getAge())
                .gender(gender)
                .roles(role)
                .build();
    }

    private Set<Role> rolesToRoleDTO(Set<RoleDTO> roleDTO){
        return roleDTO.stream().map(this::roleToRoleDTO).collect(Collectors.toSet());
    }

    private Role roleToRoleDTO(RoleDTO roleDTO){
        return Role.builder()
                .id(roleDTO.getId())
                .name(roleDTO.getName())
                .build();
    }


}
