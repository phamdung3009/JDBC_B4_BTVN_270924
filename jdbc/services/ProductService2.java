package com.jdbc.services;

import com.jdbc.connection.DatabaseConnection;
import com.jdbc.connection.InfoDatabase;
import com.jdbc.model.Category;
import com.jdbc.model.Product;
import com.jdbc.repository.ProductRepo;

import java.sql.*;

public class ProductService2 implements ProductRepo {
    private static final String QUERY_SELECT_CATEGORY = "SELECT * FROM category";
    private static final String QUERY_SELECT_PRODUCT = "SELECT * FROM product";
    private static final String QUERY_CATEGORY_EXIST = "SELECT * FROM category WHERE name = ?";
    private static final String QUERY_INSERT_PRODUCT = "INSERT INTO product (id,NAME,price,cat_id) VALUES (?, ?, ?, ?)";
    private static final String QUERY_INSERT_CATE = "INSERT INTO category (name) VALUES (?)";
    private static final String QUERY_UPDATE_BY_ID = "UPDATE product SET NAME = ?, price = ?, cat_id = ? WHERE id = ?";
    private static final String QUERY_DELETE_BY_ID = "DELETE FROM product WHERE id  = ?";
    private static final String QUERY_DESC = "SELECT p.name, p.price, c.id, c.name FROM product p JOIN category c ON p.cat_id = c.id ORDER BY p.price DESC";
    private static final String QUERY_ASC = "SELECT * FROM product p JOIN category c ON p.cat_id = c.id ORDER BY p.price ASC";
    private static final String QUERY_FIND_NAME = "SELECT * FROM product p JOIN category c ON p.cat_id = c.id WHERE p.name LIKE ? AND c.name LIKE ?";

    public static DatabaseConnection db = new DatabaseConnection();

    @Override
    public void exitsCategory(Category category, Product product) {
        Connection con = db.getConnection(InfoDatabase.DB_URL, InfoDatabase.USER_NAME, InfoDatabase.PASS_WORD);
        try {
            PreparedStatement ps = con.prepareStatement(QUERY_CATEGORY_EXIST);
            ps.setString(1, category.getName());
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                PreparedStatement ps2 = con.prepareStatement(QUERY_INSERT_CATE);
                ps2.setString(1, category.getName());
                ps2.executeUpdate();
            }
            PreparedStatement ps3 = con.prepareStatement(QUERY_INSERT_PRODUCT);
            ps3.setInt(1, product.getId());
            ps3.setString(2, product.getName());
            ps3.setDouble(3, product.getPrice());
            ps3.setInt(4, product.getCategory().getId());
            ps3.executeUpdate();
            ResultSet rs2 = con.createStatement().executeQuery(QUERY_SELECT_PRODUCT);
            while (rs2.next()) {
                product.setId(rs2.getInt(1));
                product.setName(rs2.getString(2));
                product.setPrice(rs2.getDouble(3));
                Category cat = new Category();
                cat.setId(rs2.getInt("id"));
                product.setCategory(cat);
                System.out.println(product);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProductById(Product product) {
        Connection con = db.getConnection(InfoDatabase.DB_URL, InfoDatabase.USER_NAME, InfoDatabase.PASS_WORD);
        try {
            PreparedStatement ps = con.prepareStatement(QUERY_UPDATE_BY_ID);
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getCategory().getId());
            ps.setInt(4, product.getId());
            int checkUpdate = ps.executeUpdate();
            if (checkUpdate == 1) {
                System.out.println("Product updated successfully");
            } else {
                System.out.println("Product not updated");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProductById(int id) {
        Connection con = db.getConnection(InfoDatabase.DB_URL, InfoDatabase.USER_NAME, InfoDatabase.PASS_WORD);
        try {
            PreparedStatement ps = con.prepareStatement(QUERY_DELETE_BY_ID);
            ps.setInt(1, id);
            int checkDelete = ps.executeUpdate();
            if (checkDelete == 1) {
                System.out.println("Product deleted successfully");
            } else {
                System.out.println("Product not deleted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sortProductDescInCategory() {
        Connection con = db.getConnection(InfoDatabase.DB_URL, InfoDatabase.USER_NAME, InfoDatabase.PASS_WORD);
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(QUERY_DESC);
            while (rs.next()) {
                Product product = new Product();
                Category category = new Category();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setCategory(category);
                category.setId(rs.getInt(3));
                category.setName(rs.getString(4));
                System.out.println(product + " - " + category);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sortProductAscInCategory() {
        Connection con = db.getConnection(InfoDatabase.DB_URL, InfoDatabase.USER_NAME, InfoDatabase.PASS_WORD);
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(QUERY_ASC);
            while (rs.next()) {
                Product product = new Product();
                Category category = new Category();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                product.setCategory(category);
                category.setId(rs.getInt(5));
                category.setName(rs.getString(6));
                System.out.println(product /*+ " - " + category*/);
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void findProdAndCateByName(String nameProd, String cateName) {
        Connection con = db.getConnection(InfoDatabase.DB_URL, InfoDatabase.USER_NAME, InfoDatabase.PASS_WORD);
        try {
            PreparedStatement ps = con.prepareStatement(QUERY_FIND_NAME);
            ps.setString(1, "%" + nameProd + "%");
            ps.setString(2, "%" + cateName + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Product pro = new Product();
                Category cate = new Category();
                pro.setId(rs.getInt(1));
                pro.setName(rs.getString(2));
                pro.setPrice(rs.getDouble(3));
                pro.setCategory(cate);
                cate.setId(rs.getInt(5));
                cate.setName(rs.getString(6));
                System.out.println(pro /*+ " - " + cate*/);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
