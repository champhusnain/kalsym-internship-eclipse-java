package com.javatpoint.restapientityrelationship.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatpoint.restapientityrelationship.model.Variants;

@Repository
public interface VariantsRepository extends JpaRepository<Variants, Long> {
}