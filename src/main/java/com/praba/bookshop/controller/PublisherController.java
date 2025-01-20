package com.praba.bookshop.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.praba.bookshop.model.Publisher;
import com.praba.bookshop.service.PublisherService;
import com.praba.bookshop.service.exceptions.AddressNotFoundException;
import com.praba.bookshop.service.exceptions.PublisherNotFoundException;

@RestController
@RequestMapping("/api/v1/publishers")
public class PublisherController {

	@Autowired
	private PublisherService publisherService;
	
	@PostMapping()
	public ResponseEntity<Publisher> addPublisher(@RequestBody Publisher publisher) {
		publisherService.save(publisher);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(publisher.getPublisherId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}

	@PutMapping()
	public ResponseEntity<Publisher> addPublisherToAddress(@RequestBody Publisher publisher) {
		publisherService.addPublisherToAddress(publisher);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(publisher.getPublisherId())
				.toUri();
		
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/{id}")
	public Publisher getById(@PathVariable int id) {
		return publisherService.findById(id);
	}
		
	@GetMapping()
	public List<Publisher> allPublishers() {
		return publisherService.findAll();
	}
	
	@DeleteMapping("/{id}")
	public void deletePublisher(@PathVariable int id) {
		publisherService.delete(id);
	}
	
	@ExceptionHandler({PublisherNotFoundException.class, AddressNotFoundException.class})
	public ResponseEntity<String> handleNotFoundException(Exception exception){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
	}

}
