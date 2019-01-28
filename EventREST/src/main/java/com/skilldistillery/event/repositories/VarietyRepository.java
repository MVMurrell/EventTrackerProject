package com.skilldistillery.event.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.event.entities.Variety;

public interface VarietyRepository extends JpaRepository<Variety, Integer> {

}
