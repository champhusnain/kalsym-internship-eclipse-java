package com.javatpoint.restapientityrelationship.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.javatpoint.restapientityrelationship.exception.ResourceNotFoundException;
import com.javatpoint.restapientityrelationship.model.Products;
import com.javatpoint.restapientityrelationship.model.Category;
import com.javatpoint.restapientityrelationship.model.Variants;
import com.javatpoint.restapientityrelationship.repository.ProductsRepository;
import com.javatpoint.restapientityrelationship.repository.CategoryRepository;
import com.javatpoint.restapientityrelationship.repository.VariantsRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class VariantsController {

  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private ProductsRepository productsRepository;
  
  @Autowired
  private VariantsRepository variantsRepository;

  /*@GetMapping("/categorys/{categoryId}/productss")
  public ResponseEntity<List<Products>> getAllProductssByCategoryId(@PathVariable(value = "categoryId") Long categoryId) {    
    Category category = categoryRepository.findById(categoryId)
        .orElseThrow(() -> new ResourceNotFoundException("Not found Category with id = " + categoryId));

    List<Products> productss = new ArrayList<Products>();
    productss.addAll(category.getProductss());
    
    return new ResponseEntity<>(productss, HttpStatus.OK);
  }*/

  /*@GetMapping("/productss/{id}")
  public ResponseEntity<Products> getProductssByCategoryId(@PathVariable(value = "id") Long id) {
    Products products = productsRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Not found Products with id = " + id));

    return new ResponseEntity<>(products, HttpStatus.OK);
  }*/

  @PostMapping("/categorys/{categoryId}/productss/{Id}/variants")
  public ResponseEntity<Variants> createVariants(@PathVariable(value = "Id") Long productId,
      @RequestBody Variants variantsRequest) {
    Variants variants = categoryRepository.findById(productId).map(products -> {
      products.getVariants().add(variantsRequest);
      return variantsRepository.save(variantsRequest);
    }).orElseThrow(() -> new ResourceNotFoundException("Not found Category with id = " + productId));

    return new ResponseEntity<>(variants, HttpStatus.CREATED);
  }

  /*@PutMapping("/productss/{id}")
  public ResponseEntity<Products> updateProducts(@PathVariable("id") long id, @RequestBody Products productsRequest) {
    Products products = productsRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("ProductsId " + id + "not found"));

    products.setContent(productsRequest.getContent());

    return new ResponseEntity<>(productsRepository.save(products), HttpStatus.OK);
  }*/

  /*@DeleteMapping("/productss/{id}")
  public ResponseEntity<HttpStatus> deleteProducts(@PathVariable("id") long id) {
    productsRepository.deleteById(id);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }*/
  
  /*@DeleteMapping("/categorys/{categoryId}/productss")
  public ResponseEntity<List<Products>> deleteAllProductssOfCategory(@PathVariable(value = "categoryId") Long categoryId) {
    Category category = categoryRepository.findById(categoryId)
        .orElseThrow(() -> new ResourceNotFoundException("Not found Category with id = " + categoryId));
    
    category.removeProductss();
    categoryRepository.save(category);
    
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }*/
}
