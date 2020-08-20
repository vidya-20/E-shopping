package com.online.dao;

import java.util.List;

import com.online.model.Category;

public interface categoryDao {
	public boolean addCategory(Category category);

	public boolean deleteCategory(Category category);

	public boolean updateCategory(Category category);

	public List<Category> listCategories();

	public Category getCategory(int categoryId);
}
