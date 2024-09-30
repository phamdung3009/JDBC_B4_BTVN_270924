package com.jdbc.repository;

import com.jdbc.model.Category;
import com.jdbc.model.Product;

public interface ProductRepo {
    public void exitsCategory(Category category,Product product);

    public void updateProductById(Product product);

    public void deleteProductById(int id);

    public void sortProductDescInCategory();

    public void sortProductAscInCategory();

    public void findProdAndCateByName(String nameProd, String cateName);
}
