package com.jdbc;

import com.jdbc.model.Category;
import com.jdbc.model.Product;
import com.jdbc.services.ProductService2;

public class Test {
    static ProductService2 pro = new ProductService2();

    // exitsCategory
    public Category checkExisted() {
        Category cat = new Category();
        cat.setName("Gia dung");
        return cat;
    }

    public Product product() {
        Product prod = new Product();
        Category cat = new Category();
        cat.setId(6);
        prod.setId(29);
        prod.setName("Lo Vi Song");
        prod.setPrice(25.00);
        prod.setCategory(cat);
        return prod;
    }

    // updateProductById
    public Product productUpdate() {
        Product prod = new Product();
        Category cat = new Category();
        cat.setId(6);
        prod.setId(29);
        prod.setName("Lo Vi Song TEST");
        prod.setPrice(27.00);
        prod.setCategory(cat);
        return prod;
    }

    public static void main(String[] args) {
        Test t = new Test();
//        pro.exitsCategory(t.checkExisted(), t.product());
//        pro.updateProductById(t.productUpdate());
//        pro.deleteProductById(28);
//        pro.sortProductDescInCategory();
//        pro.sortProductAscInCategory();
        pro.findProdAndCateByName("t", "t");
    }

}
