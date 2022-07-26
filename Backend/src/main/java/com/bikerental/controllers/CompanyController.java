package com.bikerental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikerental.entities.Company;
import com.bikerental.services.CompanyService;

@CrossOrigin
@RestController
@RequestMapping("/api/companies")
public class CompanyController {
	
	@Autowired private CompanyService cservice;
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Company request) {		
		cservice.saveCompany(request);
		return ResponseEntity.ok("Company registered successfully");
	}
	
	@GetMapping
	public ResponseEntity<?> findAll() {		
		return ResponseEntity.ok(cservice.listall());
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") int id) {
		cservice.deleteCompany(id);
		return ResponseEntity.ok("Deleted successfully");
	}

}
