package com.medicalProject.Service;

import com.medicalProject.Model.Medicine;

public interface MedicineService {

     Medicine addMedicine(Medicine medicine);

     void delMedicine(int mId);

     Medicine getMedicineById(Integer medId);

     Medicine updateMed(Medicine medicine);
}
