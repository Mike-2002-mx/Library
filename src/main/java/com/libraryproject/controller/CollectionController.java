package com.libraryproject.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.libraryproject.exception.ExceptionHandlerAdvice;
import com.libraryproject.model.Collection;
import com.libraryproject.service.CollectionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("collections")
@CrossOrigin(origins = "http://localhost:3000", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
@Tag(name="Collections", description="Provides methods for managing collections")
public class CollectionController {

    @Autowired
	private CollectionService service;

	@Operation(summary="Get all collections")
    @ApiResponse(responseCode="200", description="Found collections", content={
        @Content(mediaType="application/json", array=@ArraySchema(schema=@Schema(implementation=Collection.class)))   
    })
    @GetMapping
	public List<Collection> getAll() {
		return service.getAll();
	}

    @Operation(summary = "Gets Collections using id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the collection", content = @Content(schema = @Schema(implementation = Collection.class))),
            @ApiResponse(responseCode = "404", description = "author doesn't exits", content = @Content(schema = @Schema(implementation = ExceptionHandlerAdvice.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = ExceptionHandlerAdvice.class)))
    })
    @GetMapping("{idCollection}")
    public ResponseEntity<Collection> getByIdCollection(@PathVariable int idCollection) {
		Collection collections = service.getByIdCollection(idCollection);
		return new ResponseEntity<>(collections, HttpStatus.OK);
	}

	@Operation(summary = "Add new Collection")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Save record", content = @Content(schema = @Schema(implementation = Collection.class))),
            @ApiResponse(responseCode = "400", description = "Bad request", content = @Content(schema = @Schema(implementation = ExceptionHandlerAdvice.class)))
    })
    @PostMapping
	public void register(@RequestBody Collection collections) {
		service.save(collections);
	}

	@Operation(summary = "Update Collection")
    @ApiResponse(responseCode = "200", description = "Update Genre", content = {
        @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Collection.class)))
    })
	@PutMapping("{idCollection}")
	public ResponseEntity<?> update(@RequestBody Collection collections, @PathVariable int idCollection) {
		try {
			Collection auxCollection = service.getByIdCollection(idCollection);
			collections.setIdCollection(auxCollection.getIdCollection());
			service.save(collections);
			return new ResponseEntity<>("Updated record", HttpStatus.OK);
		}catch (NoSuchElementException e) {
			return new ResponseEntity<>("The record with the control number provided is not found in the database", HttpStatus.NOT_FOUND);
		}
	}

	@Operation(summary = "Delete Collection")
    @ApiResponse(responseCode = "200", description = "Delete Collection", content = {
        @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Collection.class)))
    })
	@DeleteMapping("{idCollection}")
	public void delete(@PathVariable int idCollection) {
		service.delete(idCollection);
	}

}
