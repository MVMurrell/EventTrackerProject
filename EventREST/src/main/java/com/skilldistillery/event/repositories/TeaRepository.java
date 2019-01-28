package com.skilldistillery.event.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.event.entities.Tea;

public interface TeaRepository extends JpaRepository<Tea, Integer>{

}
