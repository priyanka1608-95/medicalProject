package com.medicalProject.Service;

import com.medicalProject.Model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {


    Customer findAndAddCustomer(Customer customer);

    List<Customer> getAllCustomers();
}
