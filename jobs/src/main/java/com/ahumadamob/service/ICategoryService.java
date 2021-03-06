package com.ahumadamob.service;

import java.util.List;

import com.ahumadamob.model.Category;

public interface ICategoryService {
	
	List<Category> fetchAll();
	Category fetchById(Integer idCategory);
	void save(Category category);

}
