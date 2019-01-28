package com.skilldistillery.event.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilldistillery.event.entities.TeaDetail;

public interface TeaDetailRepository extends JpaRepository<TeaDetail, Integer> {

}
