package ru.rmanokhin.myproject.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rmanokhin.myproject.dto.PersonDTO;
import ru.rmanokhin.myproject.entity.persons.Person;
import ru.rmanokhin.myproject.mappers.MappingUtils;
import ru.rmanokhin.myproject.service.PersonService;

import java.util.List;

/**
 * http://localhost:8080/swagger-ui/index.html
 * */

@RestController
@RequestMapping("/")
@Tag(name = "Person RestController", description = "The User API")
@RequiredArgsConstructor
public class MainController {

    private final PersonService personService;
    private final MappingUtils mappingUtils;

    @Operation(summary = "Gets all person", tags = "Person RestController")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Found the users",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Person.class)))
                    })
    })
    @GetMapping("/all")
    public ResponseEntity<List<Person>> getAllPerson() {
        return ResponseEntity.ok(personService.getAllPerson());
    }

    @Operation(summary = "Save person", tags = "Person RestController")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Save person",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Person.class)))
                    })
    })
    @PostMapping("/save")
    public ResponseEntity<Person> savePerson(@RequestBody PersonDTO personDTO) {
        Person person = mappingUtils.PersonDTOToPersona(personDTO);

        return ResponseEntity.ok(personService.savePerson(person));
    }

    @Operation(summary = "Delete person", tags = "Person RestController")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Delete person",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Person.class)))
                    })
    })
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable Long id) {
        personService.deletePersonById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "Update user by id", tags = "Person RestController")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Update the person",
                    content = {@Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = Person.class)))
                    })
    })
    @PutMapping("/put/{id}")
    public ResponseEntity<Person> updatePersona(@PathVariable Long id, @RequestBody PersonDTO personDTO) {
        Person person = mappingUtils.PersonDTOToPersona(personDTO);
        person.setId(id);
        return ResponseEntity.ok(personService.savePerson(person));
    }

}
