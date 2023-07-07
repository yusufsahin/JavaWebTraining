package org.example.dao.impl;

import org.example.dao.CustomerDao;
import org.example.db.DbConnection;
import org.example.model.Customer;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CustomerDaoImpl implements CustomerDao {
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        Connection connection = DbConnection.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customers");
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setFirstname(rs.getString("firstname"));
                customer.setLastname(rs.getString("lastname"));
                customer.setAge(rs.getInt("age"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }
    public Customer getCustomer(int id) {
        Connection connection = DbConnection.getConnection();
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM customers WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Customer(rs.getInt("id"), rs.getString("firstname"), rs.getString("lastname"), rs.getInt("age"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Customer createCustomer(Customer customer) {
        Connection connection = DbConnection.getConnection();
        try {
            String query = "INSERT INTO customers (firstname, lastname, age) VALUES (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, customer.getFirstname());
            ps.setString(2, customer.getLastname());
            ps.setInt(3, customer.getAge());
            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        customer.setId(rs.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    public void updateCustomer(Customer customer) {
        Connection connection = DbConnection.getConnection();
        try {
            String query = "UPDATE customers SET firstname = ?, lastname = ?, age = ? WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, customer.getFirstname());
            ps.setString(2, customer.getLastname());
            ps.setInt(3, customer.getAge());
            ps.setInt(4, customer.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteCustomer(int id) {
        Connection connection = DbConnection.getConnection();
        try {
            String query = "DELETE FROM customers WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
