package com.skilldistillery.event.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.event.entities.Coffee;

public interface CoffeeRepository extends JpaRepository<Coffee, Integer> {

}
