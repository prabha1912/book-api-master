package com.praba.bookshop.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.praba.bookshop.model.Author;
import com.praba.bookshop.service.AuthorService;
import com.praba.bookshop.service.exceptions.AuthorExistsException;
import com.praba.bookshop.service.exceptions.AuthorNotFoundException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api/v1/authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	@Operation(
		method = "POST",
		description = "Creates a new author resource",
		responses = {
				@ApiResponse(
						responseCode = "201", 
						content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)},
						headers = {@Header(
								name="location", 
								description = "Location where the new resource is available", required=true)}
		),
		@ApiResponse(responseCode = "400", content =  {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})}
	)
	@PostMapping
	public ResponseEntity<Author> save(@Valid @RequestBody Author author) {

		authorService.save(author);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(author.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();

	}

	@GetMapping()
	public List<Author> allAuthors(Model model) {
		System.err.println("@@@@@@@@@@@@@@@@@@@@@@@@@@ BOOK API 1 @@@@@@@@@@@@@@@@@@@@@@@@@@");
		return authorService.findAll();
	}
	
	// Swagger API documentation created at http://localhost:8080/swagger-ui/index.html
	@Operation(
		method = "GET",
		description = "Returns a single author resource by the supplied id",
		responses = {
				@ApiResponse(responseCode = "200", description = "Description for 200 OK",  content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
				@ApiResponse(responseCode = "400", content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)}),
		}
	)
	@GetMapping("/{id}")
	public Author getById(@PathVariable int id) {
		return authorService.findById(id);
	}
	
	@PutMapping
	public Author update(@RequestBody Author author) {
		return authorService.save(author);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		authorService.delete(id);
		return;
	}

	@ExceptionHandler(AuthorNotFoundException.class)
	public ResponseEntity<String> handleAuthorNotFound(AuthorNotFoundException anfe) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(anfe.getMessage());
	}
	
	@ExceptionHandler(AuthorExistsException.class)
	public ResponseEntity<String> handleAuthorExists(AuthorExistsException aee) {
		return ResponseEntity.status(HttpStatus.CONFLICT).body(aee.getMessage());
	}
	
	/**
	 * Handles javax.validation.constraints exceptions.
	 * Each error in the Spring BindingResult is extracted into a Map.
	 * 
	 * @param manve MethodArgumentNotValidException
	 * @return Map containing each validation error.
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
	  MethodArgumentNotValidException manve) {
	    Map<String, String> errors = new HashMap<>();
	    manve.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    return errors;
	}
}
