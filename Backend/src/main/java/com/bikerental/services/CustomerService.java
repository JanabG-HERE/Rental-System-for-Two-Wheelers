package com.bikerental.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bikerental.daos.CustomerRepository;
import com.bikerental.entities.Customer;

@Service
public class CustomerService {

	@Autowired private CustomerRepository dao;
	
	public void registerCustomer(Customer cust) {
		dao.save(cust);
	}
	
	public Customer findByUserId(String userid) {
		return dao.getById(userid);
	}

	public List<Customer> allCustomers() {
		// TODO Auto-generated method stub
		return dao.findAll(Sort.by(Direction.DESC, "createdon"));
	}

	public Customer validate(String userid, String pwd) {
		Customer cc=dao.getById(userid);
		if(cc!=null && cc.getPwd().equals(pwd)) {
			return cc;
		}
		return null;
	}
	
	public boolean verifyUserId(String userid) {
		// TODO Auto-generated method stub
		return dao.existsById(userid);
	}

	public void updateProfile(Customer cust) {
		// TODO Auto-generated method stub
		if(cust.getPwd().equals("") || cust.getPwd()==null) {
			cust.setPwd(dao.getById(cust.getUserid()).getPwd());
		}
		dao.save(cust);	
	}
}
