package com.example.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotel.entity.Hotel;
import com.example.hotel.repo.Hotelrepo;

@Service
public class HotelServices 
{

	@Autowired
	private Hotelrepo repo;
	
	public Hotel create(Hotel obj)
	{
		return repo.save(obj);
		
	}
	public Hotel getById(int id) {
	    return repo.findById(id)
	            .orElseThrow(() -> new RuntimeException("Hotel not found with id: " + id));
	}
	public List<Hotel> all()
	{
		return repo.findAll();
	}
	
}
