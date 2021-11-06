package ru.rmanokhin.myproject.entity.persons;

import lombok.*;
import ru.rmanokhin.myproject.entity.enums.Gender;
import ru.rmanokhin.myproject.entity.roles.Role;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity(name = "student")
public class Student extends Employees{

    @NonNull
    @Column(name = "name", length = 25)
    private String name;

    @NonNull
    @Column(name = "surname", length = 25)
    private String surname;

    @NonNull
    @Column(name = "age", length = 120)
    private Integer age;

    @NonNull
    @Enumerated(EnumType.STRING)
    private Gender sex;

    @ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "student_roles",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Person person = (Person) o;
        return Objects.equals(getName(), person.getName()) && Objects.equals(getSurname(), person.getSurname()) && Objects.equals(getAge(), person.getAge()) && getSex() == person.getGender();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getName(), getSurname(), getAge(), getSex());
    }

}
