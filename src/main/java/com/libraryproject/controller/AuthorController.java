package com.libraryproject.controller;

import java.util.List;

import com.libraryproject.dto.AuthorRequestDTO;
import com.libraryproject.dto.AuthorResponse;

import org.modelmapper.ModelMapper;
import com.libraryproject.exception.ExceptionHandlerAdvice;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.libraryproject.model.Author;
import com.libraryproject.service.AuthorService;

import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("authors")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
		RequestMethod.PUT })
@Tag(name="Authors", description="Provides methods for managing Authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private ModelMapper modelMapper;

    @Operation(summary="Get all authors")
    @ApiResponse(responseCode="200", description="Found authors", content={
        @Content(mediaType="application/json", array=@ArraySchema(schema=@Schema(implementation=AuthorResponse.class)))   
    })
    @GetMapping
    public List<Author> getAll(){
        return authorService.getAll();
    }


    @Operation(summary = "Gets author using id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the author", content = @Content(schema = @Schema(implementation = AuthorResponse.class))),
            @ApiResponse(responseCode = "404", description = "author doesn't exits", content = @Content(schema = @Schema(implementation = ExceptionHandlerAdvice.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = ExceptionHandlerAdvice.class)))
    })
    @GetMapping("{idAuthor}")
    public ResponseEntity<?> getById(@PathVariable  Integer idAuthor){
        AuthorResponse author = authorService.getById(idAuthor);
        return new ResponseEntity<AuthorResponse>(author, HttpStatus.CREATED);
    }


    @Operation(summary = "Add new author")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Save record", content = @Content(schema = @Schema(implementation = AuthorResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = ExceptionHandlerAdvice.class)))
    })
    @PostMapping
    public ResponseEntity<?> add(@RequestBody AuthorRequestDTO authorRequestDTO){
        Author author = modelMapper.map(authorRequestDTO, Author.class);
        authorService.save(author);
        return new ResponseEntity<String>("Autor guardado correctamente", HttpStatus.CREATED);
    }


    @Operation(summary = "Delete author")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "The author was removed", content = @Content(schema = @Schema(implementation = AuthorResponse.class))),
            @ApiResponse(responseCode = "404", description = "author doesn't exits", content = @Content(schema = @Schema(implementation = ExceptionHandlerAdvice.class)))
    })
    @DeleteMapping("/{id}")
	public void deleteAuthor(@PathVariable Integer id) {
		authorService.delete(id);
	}

    @Operation(summary = "Search Author by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Author found", content = @Content(schema = @Schema(implementation = AuthorResponse.class))),
            @ApiResponse(responseCode = "404", description = "Author doesn't exits", content = @Content(schema = @Schema(implementation = ExceptionHandlerAdvice.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = ExceptionHandlerAdvice.class)))
    })
    @GetMapping("/searchName/{authorName}")
    public ResponseEntity<List<Author>> getByName(@PathVariable String authorName){
        List<Author> authors = authorService.findByAuthorName(authorName);
        return  new ResponseEntity<List<Author>>(authors, HttpStatus.OK);
    }

    @Operation(summary = "Search Author by nationality")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Author found", content = @Content(schema = @Schema(implementation = AuthorResponse.class))),
            @ApiResponse(responseCode = "404", description = "author doesn't exits", content = @Content(schema = @Schema(implementation = ExceptionHandlerAdvice.class)))
    })
    @GetMapping("/searchNationality/{nationality}")
    public ResponseEntity<List<Author>> getByNationality(@PathVariable String nationality){
        List<Author> authors = authorService.findByNationality(nationality);
        return  new ResponseEntity<List<Author>>(authors, HttpStatus.OK);
    }
    
}
