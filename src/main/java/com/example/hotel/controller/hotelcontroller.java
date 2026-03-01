package com.example.hotel.controller;

import java.awt.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel.entity.Hotel;
import com.example.hotel.services.HotelServices;

@RestController
public class hotelcontroller 
{
	@Autowired
	private HotelServices ser;
	@PostMapping("/insert")
	public Hotel fun1(Hotel obj)
	{
		return ser.create(obj);
	}
	@GetMapping("/alluser")
	public java.util.List<Hotel> fun2()
	{
		return ser.all();
	}
	@GetMapping("/userid/{id}")
	public Hotel fun2( @RequestBody int id)
	{
		return ser.getById(id);
	}
	
	

}
