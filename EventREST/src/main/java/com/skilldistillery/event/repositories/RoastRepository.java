package com.skilldistillery.event.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.event.entities.Roast;

public interface RoastRepository extends JpaRepository<Roast, Integer> {

}
