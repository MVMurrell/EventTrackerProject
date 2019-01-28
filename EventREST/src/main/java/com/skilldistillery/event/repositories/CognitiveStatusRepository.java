package com.skilldistillery.event.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.event.entities.CognitiveStatus;

public interface CognitiveStatusRepository extends JpaRepository<CognitiveStatus, Integer> {

}
