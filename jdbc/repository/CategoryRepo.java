package com.jdbc.repository;

import com.jdbc.model.Category;

public interface CategoryRepo {
    public void insertCategory(Category category);
    public void updateCategory(Category category);
    public void deleteCategory(int id);
    public void findById(Category category);
    public void findByName(Category category);
}
