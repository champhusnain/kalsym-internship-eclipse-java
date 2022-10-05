package com.javatpoint.restapientityrelationship.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.javatpoint.restapientityrelationship.exception.ResourceNotFoundException;
import com.javatpoint.restapientityrelationship.model.Category;
import com.javatpoint.restapientityrelationship.repository.CategoryRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CategoryController {

  @Autowired
  CategoryRepository categoryRepository;

  @GetMapping("/categorys")
  public ResponseEntity<List<Category>> getAllCategorys(@RequestParam(required = false) String title) {
    List<Category> categorys = new ArrayList<Category>();

    if (title == null)
      categoryRepository.findAll().forEach(categorys::add);
    else
      categoryRepository.findByTitleContaining(title).forEach(categorys::add);

    if (categorys.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    return new ResponseEntity<>(categorys, HttpStatus.OK);
  }

  @GetMapping("/categorys/{id}")
  public ResponseEntity<Category> getCategoryById(@PathVariable("id") long id) {
    Category category = categoryRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Not found Category with id = " + id));

    return new ResponseEntity<>(category, HttpStatus.OK);
  }

  @PostMapping("/categorys")
  public ResponseEntity<Category> createCategory(@RequestBody Category category) {
    Category _category = categoryRepository.save(new Category(category.getTitle(), category.getDescription(), true));
    return new ResponseEntity<>(_category, HttpStatus.CREATED);
  }

  @PutMapping("/categorys/{id}")
  public ResponseEntity<Category> updateCategory(@PathVariable("id") long id, @RequestBody Category category) {
    Category _category = categoryRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Not found Category with id = " + id));

    _category.setTitle(category.getTitle());
    _category.setDescription(category.getDescription());
    _category.setPublished(category.isPublished());
    
    return new ResponseEntity<>(categoryRepository.save(_category), HttpStatus.OK);
  }

  @DeleteMapping("/categorys/{id}")
  public ResponseEntity<HttpStatus> deleteCategory(@PathVariable("id") long id) {
    categoryRepository.deleteById(id);
    
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @DeleteMapping("/categorys")
  public ResponseEntity<HttpStatus> deleteAllCategorys() {
    categoryRepository.deleteAll();
    
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @GetMapping("/categorys/published")
  public ResponseEntity<List<Category>> findByPublished() {
    List<Category> categorys = categoryRepository.findByPublished(true);

    if (categorys.isEmpty()) {
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    return new ResponseEntity<>(categorys, HttpStatus.OK);
  }
}

