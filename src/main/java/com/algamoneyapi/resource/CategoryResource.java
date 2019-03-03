package com.algamoneyapi.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algamoneyapi.model.Category;
import com.algamoneyapi.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryResource {

	@Autowired
	private CategoryService cateService;

	@GetMapping
	public List<Category> findAll() {
		return cateService.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Category> createCategory(@RequestBody Category category, HttpServletResponse response) {
		Category categorySaved = cateService.save(category);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(categorySaved.getId()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		return ResponseEntity.created(uri).body(categorySaved);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category category = cateService.findById(id);
		return category != null ? ResponseEntity.ok(category) : ResponseEntity.noContent().build();
	}

}
