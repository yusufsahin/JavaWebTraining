package org.example.controller;

import org.example.dao.impl.CustomerDaoImpl;
import org.example.model.Customer;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("api/customers")
public class CustomerResource {
    private CustomerDaoImpl customerDao;

    public CustomerResource() {
        customerDao= new CustomerDaoImpl();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomer(@PathParam("id") int id) {
        return customerDao.getCustomer(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void createCustomer(Customer customer) {
        customerDao.createCustomer(customer);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateCustomer(@PathParam("id") int id, Customer customer) {
        if (customerDao.getCustomer(id) != null) {
            customerDao.updateCustomer(customer);
        }
    }

    @DELETE
    @Path("/{id}")
    public void deleteCustomer(@PathParam("id") int id) {
        customerDao.deleteCustomer(id);
    }

}
