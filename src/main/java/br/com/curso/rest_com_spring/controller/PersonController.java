package br.com.curso.rest_com_spring.controller;

import br.com.curso.rest_com_spring.dto.PersonDTO;
import br.com.curso.rest_com_spring.dto.PersonDTOV2;
import br.com.curso.rest_com_spring.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/person/v1")
@Tag(name = "People", description = "Endpoints for managing people")
public class PersonController {

    private final PersonService personService;

    @GetMapping(value = "/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Finds a Person",
            description = "service responsible for searching Person by ID",
            tags = {"People"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonDTO.class))),
                    @ApiResponse(description = "No Content", responseCode = "204", content = {@Content}),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = {@Content}),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content}),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = {@Content}),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = {@Content})
            }
    )
    public PersonDTO findById(@PathVariable(value = "id") Long id) {
        return personService.findById(id);
    }

    @GetMapping(
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Finds all People",
            description = "service responsible for searching for all people",
            tags = {"People"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = {
                                    @Content(
                                            mediaType = "application/json",
                                            array = @ArraySchema(schema = @Schema(implementation = PersonDTO.class))
                                    )
                            }),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = {@Content}),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content}),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = {@Content}),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = {@Content})
            }
    )
    public List<PersonDTO> findAll() {
        return personService.findAll();
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Add a new Person",
            description = "service responsible for add new Person",
            tags = {"People"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonDTO.class))),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = {@Content}),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content}),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = {@Content})
            }
    )
    public PersonDTO create(@RequestBody PersonDTO personDTO) {
        return personService.create(personDTO);
    }

    @PostMapping(value = "/v2",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Update a Person",
            description = "service responsible for update a Person",
            tags = {"People"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonDTO.class))),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = {@Content}),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content}),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = {@Content}),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = {@Content})
            }
    )
    public PersonDTOV2 createV2(@RequestBody PersonDTOV2 personDTOV2) {
        return personService.createV2(personDTOV2);
    }

    @PutMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @Operation(summary = "Update a Person",
            description = "service responsible for update a Person",
            tags = {"People"},
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200",
                            content = @Content(schema = @Schema(implementation = PersonDTO.class))),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = {@Content}),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content}),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = {@Content}),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = {@Content})
            }
    )
    public PersonDTO update(@RequestBody PersonDTO personDTO) {
        return personService.update(personDTO);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Person",
            description = "service responsible for delete a Person",
            tags = {"People"},
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204", content = @Content),
                    @ApiResponse(description = "Bad Request", responseCode = "400", content = {@Content}),
                    @ApiResponse(description = "Unauthorized", responseCode = "401", content = {@Content}),
                    @ApiResponse(description = "Not Found", responseCode = "404", content = {@Content}),
                    @ApiResponse(description = "Internal Error", responseCode = "500", content = {@Content})
            }
    )
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
