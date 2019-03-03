package com.algamoneyapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algamoneyapi.model.Category;
import com.algamoneyapi.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository cateRepository;

	public List<Category> findAll() {
		return cateRepository.findAll();
	}

	public Category save(Category category) {
		return cateRepository.save(category);
	}

	public Category findById(Long id) {
		return cateRepository.findById(id).orElse(null);
	}
}
