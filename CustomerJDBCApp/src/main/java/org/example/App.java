package org.example;

import java.sql.*;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    private  static  final String url="jdbc:postgresql://localhost/crmData";
    private static final String user="postgres";
    private static final String password = "MyPass@2023";
    public static void main( String[] args )
    {
        Scanner scanner= new Scanner(System.in);
        
        while (true){
            System.out.println("1. List customers");
            System.out.println("2. Add customer");
            System.out.println("3. Update customer");
            System.out.println("4. Delete customer");
            System.out.println("5. Quit");
            int option =scanner.nextInt();
            
            scanner.nextLine();
            try {
                if(option==1){
                    listCustomers();
                } else if (option==2) {
                    System.out.println("Enter firstname:");
                    String firstname=  scanner.nextLine();

                    System.out.println("Enter lastname:");
                    String lastname=scanner.nextLine();

                    System.out.println("Enter age:");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    addCustomer(firstname,lastname,age);
                } else if (option==3) {
                    System.out.println("Enter customer id to update");
                    int id= scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter firstname:");
                    String firstname=  scanner.nextLine();

                    System.out.println("Enter lastname:");
                    String lastname=scanner.nextLine();

                    System.out.println("Enter age:");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    updateCustomer(id,firstname,lastname,age);
                    
                } else if (option==4) {
                    System.out.println("Enter customer id to delete");
                    int id= scanner.nextInt();
                    scanner.nextLine();
                    deleteCustomer(id);

                } else if (option==5) {
                    System.out.println("Exiting...");
                    break;
                }
                else {
                    System.out.println("Invalid option. Please try again.");
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }
        

        /*
        try {
            Connection connection= DriverManager.getConnection(url,user,password);
            String SQL = "Select * from customers";
            Statement stmt= connection.createStatement();
            ResultSet rs= stmt.executeQuery(SQL);
            while (rs.next()){
                System.out.println(rs.getInt("id")+" | "+rs.getString("firstname")+" | "+rs.getString("lastname"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
*/

    }

    private static  Connection connect() throws SQLException {
        return  DriverManager.getConnection(url,user,password);
    }

    private static void listCustomers() throws SQLException {
        String SQL = "SELECT * FROM customers ORDER BY id";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " | " + rs.getString("firstname") + " | " + rs.getString("lastname") + " | " + rs.getInt("age"));
            }
        }
    }

    private  static  void  addCustomer(String firstname,String lastname,int age) throws SQLException {
        String SQL= "INSERT INTO customers(firstname,lastname,age) VALUES (?,?,?)";
        try(Connection conn=connect();
        PreparedStatement pstmt=conn.prepareStatement(SQL)) {
            pstmt.setString(1,firstname);
            pstmt.setString(2,lastname);
            pstmt.setInt(3,age);
            pstmt.executeUpdate();
            System.out.println("Customer added successfully.");
        }
    }

    private  static  void  updateCustomer(int id,String firstname,String lastname,int age) throws SQLException {
        String SQL= "UPDATE customers SET firstname = ?, lastname = ?, age = ? WHERE id = ?";
        try(Connection conn=connect();
            PreparedStatement pstmt=conn.prepareStatement(SQL)) {
            pstmt.setString(1,firstname);
            pstmt.setString(2,lastname);
            pstmt.setInt(3,age);
            pstmt.setInt(4,id);
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows>0){
                System.out.println("Customer updated successfully.");
            }else {
                System.out.println("Customer with such id doesn't exist.");
            }
        }
    }

    private  static  void  deleteCustomer(int id) throws SQLException{
        String SQL= "DELETE FROM customers WHERE id = ?";
        try(Connection conn=connect();
            PreparedStatement pstmt=conn.prepareStatement(SQL)) {
            pstmt.setInt(1,id);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows>0){
                System.out.println("Customer deleted successfully.");
            }else {
                System.out.println("Customer with such id doesn't exist.");
            }

    }
    }
}
