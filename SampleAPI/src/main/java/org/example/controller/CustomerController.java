package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dao.CustomerDao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.domain.Customer;

import java.io.IOException;


public class CustomerController extends HttpServlet {
    private CustomerDao customerDao= new CustomerDao();
    private ObjectMapper mapper= new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        int id = extractIdFromPath(req);
        if (id == -1) {
            resp.getWriter().write(mapper.writeValueAsString(customerDao.getAllCustomers()));
        } else {
            Customer customer = customerDao.getCustomer(id);
            if (customer == null) {
                resp.sendError(HttpServletResponse.SC_NOT_FOUND, "No customer found with id: " + id);
            } else {
                resp.getWriter().write(mapper.writeValueAsString(customer));
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer newCustomer = mapper.readValue(req.getReader(), Customer.class);
        newCustomer = customerDao.createCustomer(newCustomer);
        resp.setContentType("application/json");
        resp.getWriter().write(mapper.writeValueAsString(newCustomer));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Customer existingCustomer = mapper.readValue(req.getReader(), Customer.class);
        customerDao.updateCustomer(existingCustomer);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = extractIdFromPath(req);
        if (id == -1) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "No customer id provided");
            return;
        }
        customerDao.deleteCustomer(id);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    private int extractIdFromPath(HttpServletRequest req) {
        String path = req.getPathInfo();
        if (path == null || path.equals("/")) {
            return -1;
        } else {
            try {
                return Integer.parseInt(path.substring(1));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid customer id: " + path.substring(1));
            }
        }
    }
}
