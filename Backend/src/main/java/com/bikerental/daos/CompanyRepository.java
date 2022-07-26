package com.bikerental.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikerental.entities.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
