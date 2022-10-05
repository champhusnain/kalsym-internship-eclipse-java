package com.javatpoint.restapientityrelationship.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "tutorials")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "published")
  private boolean published;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  @JoinColumn(name = "tutorial_id")
  private Set<Products> productss = new HashSet<>();
  
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
  @JoinColumn(name = "tutorial_id")
  private Set<Variants> variants = new HashSet<>();

  public Category() {

  }

  public Category(String title, String description, boolean published) {
    this.title = title;
    this.description = description;
    this.published = published;
  }

  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isPublished() {
    return published;
  }

  public void setPublished(boolean isPublished) {
    this.published = isPublished;
  }
  
  public Set<Products> getProductss() {
    return productss;
  }

  public void setProductss(Set<Products> productss) {
    this.productss = productss;
  }
  
  public void removeProductss() {
    this.productss.clear();
  }
  
  public Set<Variants> getVariants() {
	    return variants;
	  }

	  public void setVariants(Set<Variants> variants) {
	    this.variants = variants;
	  }
	  
	  public void removeVariants() {
	    this.variants.clear();
	  }
  
  @Override
  public String toString() {
    return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
  }

}