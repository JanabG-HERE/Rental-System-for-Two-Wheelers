package com.bikerental.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bikerental.daos.CompanyRepository;
import com.bikerental.entities.Company;

@Service
public class CompanyService {

	@Autowired private CompanyRepository repo;
	
	public void saveCompany(Company comp) {
		repo.save(comp);
	}
	
	public List<Company> listall(){
		return repo.findAll(Sort.by(Direction.DESC, "id"));
	}
	
	public void deleteCompany(int id) {
		repo.delete(repo.getById(id));
	}
	
	public Company findById(int id) {
		return repo.getById(id);
	}
}
