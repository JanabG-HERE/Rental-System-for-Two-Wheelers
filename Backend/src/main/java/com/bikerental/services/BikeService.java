package com.bikerental.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bikerental.daos.BikeRepository;
import com.bikerental.entities.Bike;
import com.bikerental.models.BikeDTO;

@Service
public class BikeService {

	@Autowired private BikeRepository brepo;
	@Autowired private VariantService vsrv;
	
	public void saveBike(BikeDTO dto) {
		Bike bike=new Bike();
		if(brepo.existsById(dto.getId())) {			
			bike=brepo.getById(dto.getId());
		}		
		BeanUtils.copyProperties(dto, bike);
		bike.setVariant(vsrv.findById(dto.getVarid()));
		brepo.save(bike);
	}
	
	public void updateBike(Bike bk) {
		brepo.save(bk);
	}
	
	public List<Bike> listAll(){
		return brepo.findAll(Sort.by(Direction.DESC, "createdon"));
	}
	
	public Bike findById(String id) {
		return brepo.getById(id);
	}
	
	public List<Bike> filterBikes(int id){
		System.out.println("Filter id "+id);
		if(id==1)
			return brepo.findByStatus("Available");
		else
			return brepo.findByStatus("Not Available");
	}
	
	public List<Bike> listVariantBikes(int varid){
		return brepo.findByVariantAndStatus(vsrv.findById(varid),"Available");
	}
	
	public void deleteBike(String id) {
		if(brepo.existsById(id)) {
			brepo.delete(brepo.getById(id));
		}
	}	
}
