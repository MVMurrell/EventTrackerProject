package com.skilldistillery.event.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.event.entities.CoffeeDistributer;

public interface CoffeeDistributerRepository extends JpaRepository<CoffeeDistributer, Integer> {

}
