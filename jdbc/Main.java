package com.jdbc;

import com.jdbc.connection.DatabaseConnection;
import com.jdbc.connection.InfoDatabase;
import com.jdbc.model.Category;
import com.jdbc.model.Product;
import com.jdbc.services.CategoryService;
import com.jdbc.services.ProductService;

import java.sql.*;

public class Main {
    static CategoryService categoryService = new CategoryService();
    static ProductService productService = new ProductService();

    //
    public Category cateInsert() {
        Category cate = new Category();
        cate.setId(2);
        cate.setName("Do uong");
        return cate;
    }

    public Category cateUpdate() {
        Category cate = new Category();
        cate.setId(2);
        cate.setName("Do uong");
        return cate;
    }

    public Category cateFindById() {
        Category cate = new Category();
        cate.setId(2);
        return cate;
    }

    public Category cateFindByName() {
        Category cate = new Category();
        cate.setName("d");
        return cate;
    }

    //
    public Product productUpdate() {
        Product product = new Product();
        product.setId(22);
        product.setName("Man hinh may tinh AAA");
        product.setPrice(2200);
//        product.setCat_id(5);
        return product;
    }

    public Category cateCheckExist() {
        Category cate = new Category();
        cate.setName("Thuc Phamm");
        return cate;
    }
    public Product productInsert() {
        Product product = new Product();
        product.setId(23);
        product.setName("Rau xa lach");
        product.setPrice(3200);
//        product.setCat_id(1);
        return product;
    }
    public static void main(String[] args) {
        Main main = new Main();
//        categoryService.insertCategory(main.cateInsert());
//        categoryService.updateCategory(main.cateUpdate());
//        categoryService.findById(main.cateFindById());
//        categoryService.findByName(main.cateFindByName());

//        productService.exitsCategory(main.cateCheckExist() , main.productInsert());
//        productService.updateProductById(main.productUpdate());
//        productService.deleteProductById(22);
//        productService.sortProductDescInCategory();
//        productService.sortProductAscInCategory();
        String namePro = "q";
        String nameCate = "t";
        productService.findProdAndCateByName(namePro, nameCate);
    }
}