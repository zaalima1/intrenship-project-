package com.example.hotel.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotel.entity.Hotel;

public interface Hotelrepo extends JpaRepository<Hotel, Integer> {
	

}
