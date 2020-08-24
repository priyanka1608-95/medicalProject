package com.medicalProject.Service;

import com.medicalProject.Model.Medicine;

import java.util.List;

public interface MedicineService {

      List<Medicine> getAllMeds();

     Medicine addMedicine(Medicine medicine);

     void delMedicine(int mId);

     Medicine getMedicineById(Integer medId);

     Medicine updateMed(Medicine medicine);
}
