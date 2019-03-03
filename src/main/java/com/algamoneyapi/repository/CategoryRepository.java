package com.algamoneyapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algamoneyapi.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
