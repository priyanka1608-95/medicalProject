package com.medicalProject.Repository;

import com.medicalProject.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    Customer findByCustNameOrDoctor(String custName, String doctor);


}
