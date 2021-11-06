package ru.rmanokhin.myproject.entity.persons;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Objects;


@Setter
@Getter
@NoArgsConstructor
@RequiredArgsConstructor
@SuperBuilder(toBuilder = true)
@MappedSuperclass
@ToString
public abstract class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "person_id",nullable = false, unique = true)
    private Long id;
    @NonNull
    private String email;
    @NonNull
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employees employees = (Employees) o;
        return Objects.equals(getId(), employees.getId()) && Objects.equals(getEmail(), employees.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail());
    }
}
