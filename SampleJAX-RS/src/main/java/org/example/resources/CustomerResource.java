package org.example.resources;

import org.example.model.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Path("/api/customers")
public class CustomerResource {
    private  static  final String url="jdbc:postgresql://localhost/crmData";
    private static final String user="postgres";
    private static final String password = "MyPass@2023";
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getAllCustomer()
    {
        List<Customer> customers= new ArrayList<>();

        Customer c1 = new Customer(1,"John","Doe",35);
        Customer c2 = new Customer(2,"Jane","Doe",30);
        Customer c3= new Customer(3,"Frank","Doe",27);

        customers.add(c1);
        customers.add(c2);
        customers.add(c3);

        return  customers;

      //  return "Hello World!";

    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomerById(@PathParam("id") int id) throws SQLException {
      //  Customer c= new Customer(id,"Test "+id,"Test "+id,5+id);
        Customer customer=getCustomerFromDBById(id);
        return customer;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer createCustomer(Customer customer) {
        return customer;
    }
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateCustomer(@PathParam("id") int id, Customer customer) {
        // Ensure the ID on the path matches the ID of the customer object.
        if (id != customer.getId()) {
            throw new WebApplicationException("ID on the path must match the ID of the customer object.", Response.Status.BAD_REQUEST);
        }

        //customerDao.updateCustomer(customer);
    }

    @DELETE
    @Path("/{id}")
    public  void  deleteCustomer(@PathParam("id") int id){
        ///..silme işlemi
    }

    private static  Connection connect() throws SQLException {
        return  DriverManager.getConnection(url,user,password);
    }
    private static Customer getCustomerFromDBById(int id) throws SQLException {
        String SQL = "SELECT * FROM customers WHERE id = ?";
        try {
            Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            Customer customer = null;
            while (rs.next()) {
                customer = new Customer();
                customer.setId(rs.getInt("id"));
                customer.setFirstname(rs.getString("firstname"));
                customer.setLastname(rs.getString("lastname"));
                customer.setAge(rs.getInt("age"));
            }
            return customer;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
