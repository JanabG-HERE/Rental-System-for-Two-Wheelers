package com.bikerental.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.bikerental.daos.BookingRepository;
import com.bikerental.daos.FeedbackRepository;
import com.bikerental.daos.PaymentRepository;
import com.bikerental.entities.Bike;
import com.bikerental.entities.Booking;
import com.bikerental.entities.Customer;
import com.bikerental.entities.Feedback;
import com.bikerental.entities.Payment;
import com.bikerental.entities.Variant;
import com.bikerental.models.BookingCompleteDTO;
import com.bikerental.models.BookingDTO;
import com.bikerental.models.BookingStatusDTO;

@Service
public class BookingService {

	@Autowired private BookingRepository brepo;
	@Autowired private PaymentRepository prepo;
	@Autowired private CustomerService csrv;
	@Autowired private VariantService vsrv;
	@Autowired private BikeService bksrv;
	@Autowired private FeedbackRepository frepo;
	
	public void saveBooking(BookingDTO dto) {
		System.out.println(dto);
		Customer customer=csrv.findByUserId(dto.getUserid());
		Variant variant=vsrv.findById(dto.getVarid());
		
		Booking bk=new Booking();
		BeanUtils.copyProperties(dto, bk);
		bk.setCustomer(customer);
		bk.setVariant(variant);
		System.out.println(bk);
		brepo.save(bk);
		
		Payment pmt=new Payment();
		BeanUtils.copyProperties(dto, pmt);
		pmt.setRemarks("Booking Amount");
		pmt.setBooking(bk);
		pmt.setAmount(dto.getAdvance());
		System.out.println(pmt);
		prepo.save(pmt);
		
	}
	
	public void updateBooking(BookingStatusDTO dto) {
		Booking bk=findById(dto.getBid());
		Bike bik=bksrv.findById(dto.getBno());
		bk.setBike(bik);
		bk.setStatus("Confirmed");
		brepo.save(bk);
		
		bik.setStatus("Not Available");
		bksrv.updateBike(bik);
	}
	
	public void completeBooking(BookingCompleteDTO dto) {
		Booking bk=findById(dto.getBid());
		
		Bike bike=bk.getBike();
		bike.setStatus("Available");
		bksrv.updateBike(bike);		
		
		Payment pmt=new Payment();
		pmt.setAmount(dto.getAmount());
		pmt.setBooking(bk);
		pmt.setNameoncard(dto.getNameoncard());
		pmt.setCardno(dto.getCardno());
		pmt.setRemarks("Payment completed");
		pmt.setIscompleted(true);
		prepo.save(pmt);
		
		Feedback fb=new Feedback();
		fb.setCustomer(bk.getCustomer());
		fb.setDescr(dto.getFeedback());
		fb.setRatings(dto.getRatings());
		
		frepo.save(fb);
	}
	
	public List<Feedback> allFeedbacks(){
		return frepo.findAll(Sort.by(Direction.DESC, "id"));
	}
	
	public void cancelBooking(int id) {
		List<Payment> pmts=prepo.findByBooking(brepo.getById(id));
		prepo.deleteAll(pmts);
		brepo.delete(brepo.getById(id));
	}
	
	public Booking findById(int id) {
		return brepo.getById(id);
	}
	
	public List<Booking> findAllBookings(){
		return brepo.findAll(Sort.by(Direction.DESC, "id"));
	}
	
	public List<Payment> findAllPayments(){
		return prepo.findAll(Sort.by(Direction.DESC, "id"));
	}
	
	public List<Booking> findUserBookings(String userid){
		return brepo.findByCustomer(csrv.findByUserId(userid));
	}
	
	public List<Payment> findBookingPayments(int id){
		return prepo.findByBooking(brepo.getById(id));
	}
}

/*
Stock entity=new Stock();
BeanUtils.copyProperties(dto, entity);		
return entity;
*/