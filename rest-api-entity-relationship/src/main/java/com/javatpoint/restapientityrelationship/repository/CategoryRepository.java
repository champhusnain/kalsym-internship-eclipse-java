package com.javatpoint.restapientityrelationship.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javatpoint.restapientityrelationship.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
  List<Category> findByPublished(boolean published);

  List<Category> findByTitleContaining(String title);
}
