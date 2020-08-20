package com.medicalProject.Service.Impls;

import com.medicalProject.Model.Medicine;
import com.medicalProject.Repository.MedicineRepository;
import com.medicalProject.Service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;

public class MedicineServiceImpl implements MedicineService {

    @Autowired
    MedicineRepository medicineRepository;

    @Override
    public Medicine addMedicine(Medicine medicine) {

        return medicineRepository.save(medicine);
    }
}
