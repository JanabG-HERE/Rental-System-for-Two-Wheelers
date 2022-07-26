package com.bikerental.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bikerental.entities.Bike;
import com.bikerental.entities.Variant;

@Repository
public interface BikeRepository extends JpaRepository<Bike, String> {

	List<Bike> findByVariantAndStatus(Variant variant,String status);
	List<Bike> findByStatus(String status);
}
