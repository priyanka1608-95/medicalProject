package com.medicalProject.Service.Impls;

import com.medicalProject.Model.Customer;
import com.medicalProject.Model.Medicine;
import com.medicalProject.Repository.CustomerRepository;
import com.medicalProject.Repository.MedicineRepository;
import com.medicalProject.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    MedicineRepository medicineRepository;

    @Override
    public Customer findAndAddCustomer(Customer customer) {

        float billAmt=0;
        Customer cust= customerRepository.findByCustNameOrDoctor(customer.getCustName(),customer.getDoctor());
        if(null != cust)
        {

            List<Medicine> tempMedList=customer.getMedicines();
            for ( Medicine med : tempMedList)
            {
                Medicine medicine= medicineRepository.findById(med.getMedId()).get();
                medicine.setPurchasedQty(med.getPurchasedQty());
                medicine.setRemainingQty(medicine.getRemainingQty() - medicine.getPurchasedQty());
                cust.getMedicines().add(medicine);
                billAmt+=medicine.getPrice() * medicine.getPurchasedQty();
            }
            if(cust.getAmtRemaining()!=0.0)
                cust.setAmtRemaining(cust.getAmtRemaining() + billAmt);
            cust.setAmtRemaining(cust.getAmtRemaining() - cust.getAmtPaid());
            cust.setTotalBill(billAmt);
            cust=customerRepository.save(cust);
        }
        else
        {
            for ( Medicine med : customer.getMedicines())
            {
                Medicine medicine= medicineRepository.findById(med.getMedId()).get();
                medicine.setPurchasedQty(med.getPurchasedQty());
                billAmt = billAmt + (medicine.getPrice() * medicine.getPurchasedQty());
                medicine.setRemainingQty(medicine.getRemainingQty() - medicine.getPurchasedQty());
            }
            customer.setTotalBill(billAmt);
            customer.setAmtRemaining(customer.getTotalBill() - customer.getAmtPaid());
            cust= customerRepository.save(customer);

        }
        return cust;
    }

    @Override
    public List<Customer> getAllCustomers() {

        return customerRepository.findAll();
    }


}
