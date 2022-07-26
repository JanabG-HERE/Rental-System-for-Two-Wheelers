package com.bikerental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.bikerental.models.BikeDTO;
import com.bikerental.services.BikeService;

@CrossOrigin
@RestController
@RequestMapping("/api/bikes")
public class BikesController {

	@Autowired private BikeService bservice;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody BikeDTO dto) {		
		bservice.saveBike(dto);
		return ResponseEntity.ok("Saved successfully");
	}
	
	@GetMapping
	public ResponseEntity<?> findAll() {		
		return ResponseEntity.ok(bservice.listAll());
	}
	
	@GetMapping("variants/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") int id) {		
		return ResponseEntity.ok(bservice.listVariantBikes(id));
	}
	
	@GetMapping("search")
	public ResponseEntity<?> findById(String id) {		
		return ResponseEntity.ok(bservice.findById(id));
	}
	
	@GetMapping("filter/{id}")
	public ResponseEntity<?> filterByStatus(@PathVariable("id") int id) {		
		return ResponseEntity.ok(bservice.filterBikes(id));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
		System.out.println(id);
		bservice.deleteBike(id);
		return ResponseEntity.ok("Bike deleted successfully");
	}
}
