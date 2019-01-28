package com.skilldistillery.event.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.event.entities.TeaDistributer;

public interface TeaDistributerRepository extends JpaRepository<TeaDistributer, Integer> {

}
