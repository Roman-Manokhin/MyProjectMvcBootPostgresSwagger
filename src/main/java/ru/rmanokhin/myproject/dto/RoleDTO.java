package ru.rmanokhin.myproject.dto;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {

    private Long id;
    private String name;

}