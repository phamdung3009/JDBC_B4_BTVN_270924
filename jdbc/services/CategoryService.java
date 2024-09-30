package com.jdbc.services;

import com.jdbc.connection.DatabaseConnection;
import com.jdbc.connection.InfoDatabase;
import com.jdbc.model.Category;
import com.jdbc.repository.CategoryRepo;
import com.sun.source.tree.TryTree;

import java.sql.*;

public class CategoryService implements CategoryRepo {
    public static DatabaseConnection db = new DatabaseConnection();
    public static final String QUERY_INSERT = "INSERT INTO category VALUES (?, ?);";
    public static final String QUERY_UPDATE = "UPDATE category SET NAME = ? WHERE id = ?";
    public static final String QUERY_DELETE = "DELETE FROM student WHERE id  = ?";
    public static final String QUERY_FIND_BY_ID = "SELECT id, name FROM category WHERE id = ?";
    public static final String QUERY_FIND_BY_NAME = "SELECT * FROM category WHERE NAME LIKE ?";

    @Override
    public void insertCategory(Category category) {
        Connection conn = db.getConnection(InfoDatabase.DB_URL, InfoDatabase.USER_NAME, InfoDatabase.PASS_WORD);
        try {
            PreparedStatement ps = conn.prepareStatement(QUERY_INSERT);
            ps.setInt(1, category.getId());
            ps.setString(2, category.getName());
            int checkResult = ps.executeUpdate();
            if (checkResult > 0) {
                System.out.println("Insert category successful");
            } else {
                System.out.println("Insert category failed");
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCategory(Category category) {
        Connection con = db.getConnection(InfoDatabase.DB_URL, InfoDatabase.USER_NAME, InfoDatabase.PASS_WORD);
        try {
            PreparedStatement ps = con.prepareStatement(QUERY_UPDATE);
            ps.setString(1, category.getName());
            ps.setInt(2, category.getId());
            int checkResultUpdate = ps.executeUpdate();
            if (checkResultUpdate > 0) {
                System.out.println("Update category successful");
            } else {
                System.out.println("Update category failed");
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCategory(int id) {
        Connection con = db.getConnection(InfoDatabase.DB_URL, InfoDatabase.USER_NAME, InfoDatabase.PASS_WORD);
        try {
            PreparedStatement ps = con.prepareStatement(QUERY_DELETE);
            ps.setInt(1, id);
            int checkResultDelete = ps.executeUpdate();
            if (checkResultDelete > 0) {
                System.out.println("Delete category successful");
            } else {
                System.out.println("Delete category failed");
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void findById(Category category) {
        Connection con = db.getConnection(InfoDatabase.DB_URL, InfoDatabase.USER_NAME, InfoDatabase.PASS_WORD);
        try {
            PreparedStatement ps = con.prepareStatement(QUERY_FIND_BY_ID);
            ps.setInt(1, category.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                System.out.println(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void findByName(Category category) {
        Connection con = db.getConnection(InfoDatabase.DB_URL, InfoDatabase.USER_NAME, InfoDatabase.PASS_WORD);
        try {
            PreparedStatement ps = con.prepareStatement(QUERY_FIND_BY_NAME);
            ps.setString(1, "%" + category.getName() + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                System.out.println(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
