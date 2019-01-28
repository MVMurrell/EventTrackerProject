package com.skilldistillery.event.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.event.entities.Distributer;

public interface DistributerRepository extends JpaRepository<Distributer, Integer> {

}
