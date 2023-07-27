package com.marketingapp71.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marketingapp71.entities.Lead;

public interface LeadRepository extends JpaRepository<Lead, Long> {

}
