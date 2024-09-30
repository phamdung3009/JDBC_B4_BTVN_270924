package com.jdbc.services;

import com.jdbc.connection.DatabaseConnection;
import com.jdbc.connection.InfoDatabase;
import com.jdbc.model.Category;
import com.jdbc.model.Product;
import com.jdbc.repository.ProductRepo;

import java.sql.*;

public class ProductService implements ProductRepo {
    public static DatabaseConnection db = new DatabaseConnection();
    private static String QUERY_SELECT = "SELECT * FROM product";
    private static String QUERY_UPDATE_BY_ID = "UPDATE product SET NAME = ?, price = ?, cat_id = ? WHERE id = ?";
    private static String QUERY_DELETE_BY_ID = "DELETE FROM product WHERE id  = ?";
    private static String QUERY_DESC = "SELECT * FROM product p JOIN category c ON p.cat_id = c.id ORDER BY p.price DESC";
    private static String QUERY_ASC = "SELECT * FROM product p JOIN category c ON p.cat_id = c.id ORDER BY p.price ASC";
    private static String QUERY_FIND_NAME = "SELECT * FROM product p JOIN category c ON p.cat_id = c.id WHERE p.name LIKE ? AND c.name LIKE ?";
    private static String QUERY_CHECK_EXIST_CATEGORY = "SELECT * FROM category WHERE name = ?";
    private static String QUERY_INSERT_PRODUCT = "INSERT INTO product (id,NAME,price,cat_id) VALUES (?, ?, ?, ?)";

    @Override
    public void exitsCategory(Category category, Product product) {
        Connection con = db.getConnection(InfoDatabase.DB_URL, InfoDatabase.USER_NAME, InfoDatabase.PASS_WORD);
        /*try {
            PreparedStatement ps = con.prepareStatement(QUERY_CHECK_EXIST_CATEGORY);
            ps.setString(1, category.getName());
            ResultSet rs = ps.executeQuery();
//            System.out.println(rs.next());
            if (rs.next()) {
                PreparedStatement ps2 = con.prepareStatement(QUERY_INSERT_PRODUCT);
                ps2.setInt(1, product.getId());
                ps2.setString(2, category.getName());
                ps2.setDouble(3, product.getPrice());
                ps2.setInt(4, product.getCat_id());

                int checkResult = ps2.executeUpdate();
                if (checkResult == 1) {
                    System.out.println("Insert product successfully");
                } else {
                    System.out.println("Insert product failed");
                }
            } else {
                System.out.println("Category does not exist");
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

    }

    @Override
    public void updateProductById(Product product) {
        Connection con = db.getConnection(InfoDatabase.DB_URL, InfoDatabase.USER_NAME, InfoDatabase.PASS_WORD);
        /*try {
            PreparedStatement ps = con.prepareStatement(QUERY_UPDATE_BY_ID);
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getCat_id());
            ps.setInt(4, product.getId());
            int checkUpdate = ps.executeUpdate();
            if (checkUpdate == 1) {
                System.out.println("Product updated successfully");
            } else {
                System.out.println("Product not updated");
            }
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(QUERY_SELECT);
            while (rs.next()) {
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                product.setCat_id(rs.getInt(4));
                System.out.println(product);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public void deleteProductById(int id) {
        Connection con = db.getConnection(InfoDatabase.DB_URL, InfoDatabase.USER_NAME, InfoDatabase.PASS_WORD);
        /*try {
            PreparedStatement ps = con.prepareStatement(QUERY_DELETE_BY_ID);
            ps.setInt(1, id);
            int checkResultDelete = ps.executeUpdate();
            if (checkResultDelete == 1) {
                System.out.println("Product deleted successfully");
            } else {
                System.out.println("Product not deleted");
            }
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(QUERY_SELECT);
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                product.setCat_id(rs.getInt(4));
                System.out.println(product);
            }
            con.close();
        } catch (SQLException e) {
        }*/
    }

    @Override
    public void sortProductDescInCategory() {
        Connection con = db.getConnection(InfoDatabase.DB_URL, InfoDatabase.USER_NAME, InfoDatabase.PASS_WORD);
        /*try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(QUERY_DESC);
            while (rs.next()) {
                Product product = new Product();
                Category category = new Category();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                product.setCat_id(rs.getInt(4));
                category.setId(rs.getInt(5));
                category.setName(rs.getString(6));
                System.out.println(product + " - " + category);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public void sortProductAscInCategory() {
        Connection con = db.getConnection(InfoDatabase.DB_URL, InfoDatabase.USER_NAME, InfoDatabase.PASS_WORD);
       /* try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(QUERY_ASC);
            while (rs.next()) {
                Product product = new Product();
                Category category = new Category();
                product.setId(rs.getInt(1));
                product.setName(rs.getString(2));
                product.setPrice(rs.getDouble(3));
                product.setCat_id(rs.getInt(4));
                category.setId(rs.getInt(5));
                category.setName(rs.getString(6));
                System.out.println(product + " - " + category);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    @Override
    public void findProdAndCateByName(String nameProd, String cateName) {
        Connection con = db.getConnection(InfoDatabase.DB_URL, InfoDatabase.USER_NAME, InfoDatabase.PASS_WORD);
        /*try {
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
                pro.setCat_id(rs.getInt(4));
                cate.setId(rs.getInt(5));
                cate.setName(rs.getString(6));
                System.out.println(pro + " - " + cate);
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }
}
