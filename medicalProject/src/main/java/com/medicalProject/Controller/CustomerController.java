package com.medicalProject.Controller;

import com.medicalProject.Model.Customer;
import com.medicalProject.Model.ResponseModel;
import com.medicalProject.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/addCustomer")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer)
    {
        Customer cust= customerService.findAndAddCustomer(customer);
        if(cust !=null)
            return new ResponseEntity<>(cust, HttpStatus.OK);
        else {
            ResponseModel responseModel =new ResponseModel();
            responseModel.setMessage("Cannot add customer.Try again.");
            responseModel.setStatus("FAILED");
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getAllCustomers")
    public ResponseEntity<?> getAllCustomers() {
        List<Customer> customerList = customerService.getAllCustomers();
        if (customerList != null)
            return new ResponseEntity<>(customerList, HttpStatus.OK);
        else {
            ResponseModel responseModel = new ResponseModel();
            responseModel.setMessage("No customers in the List.");
            responseModel.setStatus("FAILED");
            return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
        }
    }

}
