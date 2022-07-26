package com.bikerental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikerental.models.VariantDTO;
import com.bikerental.services.VariantService;

@CrossOrigin
@RestController
@RequestMapping("/api/variants")
public class VariantController {

	@Autowired private VariantService vservice;
	
	@PostMapping
	public ResponseEntity<?> save(VariantDTO dto) {		
		vservice.saveVariant(dto);
		return ResponseEntity.ok("Variant registered successfully");
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> save(@PathVariable("id") int id, VariantDTO dto) {		
		vservice.updateVariant(id,dto);
		return ResponseEntity.ok("Variant updated successfully");
	}
	
	@GetMapping
	public ResponseEntity<?> findAll() {		
		return ResponseEntity.ok(vservice.listall());
	}
	
	@GetMapping("company/{id}")
	public ResponseEntity<?> findAll(@PathVariable("id") int id) {		
		return ResponseEntity.ok(vservice.listByCompany(id));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> findById(@PathVariable("id") int id) {		
		return ResponseEntity.ok(vservice.findById(id));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
		vservice.deleteVariant(id);
		return ResponseEntity.ok("Deleted successfully");
	}
}
