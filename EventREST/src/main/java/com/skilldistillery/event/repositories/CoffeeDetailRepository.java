package com.skilldistillery.event.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.event.entities.CoffeeDetail;

public interface CoffeeDetailRepository extends JpaRepository<CoffeeDetail, Integer> {

}
