package com.skilldistillery.event.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.event.entities.Water;

public interface WaterRepository extends JpaRepository<Water, Integer> {

}
