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
import org.springframework.web.bind.annotation.RestController;

import com.libraryproject.model.Publisher;
import com.libraryproject.service.PublisherService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("publisher")
@CrossOrigin
@Tag (name ="Publishers", description = "Provides methods for managing Publishers")
public class PublisherController {

    @Autowired
	private PublisherService service;

	@Operation(summary = "Get All Publishers")
    @ApiResponse(responseCode= "200", description = "Found Publishers", content = {
        @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Publisher.class)))
    })
    @GetMapping
	public List<Publisher> getAll() {
		return service.getAll();
	}

	@Operation(summary = "Get Publisher By Id")
    @ApiResponse(responseCode = "200", description = "Found Publisher", content = {
        @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Publisher.class)))
    })
    @GetMapping("{idPublisher}")
    public ResponseEntity<Publisher> getByIdPublisher(@PathVariable int idPublisher) {
		Publisher publisher = service.getByIdPublisher(idPublisher);
		return new ResponseEntity<>(publisher, HttpStatus.OK);
	}

	@Operation(summary = "Add New Publisher")
    @ApiResponse(responseCode = "200", description = "Add Genre", content = {
        @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Publisher.class)))
    })
    @PostMapping
	public void register(@RequestBody Publisher publisher) {
		service.save(publisher);
	}

    @Operation(summary = "Update Publisher")
    @ApiResponse(responseCode = "200", description = "Update Publisher", content = {
        @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Publisher.class)))
    })	
	@PutMapping("{idPublisher}")
	public ResponseEntity<?> update(@RequestBody Publisher publisher, @PathVariable int idPublisher) {
		try {
			Publisher auxPublisher = service.getByIdPublisher(idPublisher);
			publisher.setIdPublisher(auxPublisher.getIdPublisher());
			service.save(publisher);
			return new ResponseEntity<>("Updated record", HttpStatus.OK);
		}catch (NoSuchElementException e) {
		return new ResponseEntity<>("The record with the control number provided is not found in the database", HttpStatus.NOT_FOUND);
		}
	}

    @Operation(summary = "Delete Publisher")
    @ApiResponse(responseCode = "200", description = "Delete Publishers", content = {
        @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Publisher.class)))
    })
	@DeleteMapping("{idPublisher}")
	public void delete(@PathVariable int idPublisher) {
		service.delete(idPublisher);
	}
}
