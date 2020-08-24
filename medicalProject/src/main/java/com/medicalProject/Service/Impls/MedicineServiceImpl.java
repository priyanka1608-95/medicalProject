package com.medicalProject.Service.Impls;

import com.medicalProject.Model.Medicine;
import com.medicalProject.Repository.MedicineRepository;
import com.medicalProject.Service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    MedicineRepository medicineRepository;

    @Override
    public List<Medicine> getAllMeds() {
        List<Medicine> medicineList=medicineRepository.findAll();
        return medicineList;
    }

    @Override
    public Medicine addMedicine(Medicine medicine) {

        return medicineRepository.save(medicine);
    }

    @Override
    public void delMedicine(int mId) {
        medicineRepository.deleteById(mId);
    }

    @Override
    public Medicine getMedicineById(Integer medId) {
        Medicine medicine=medicineRepository.findById(medId).get();
        return medicine;
    }

    @Override
    public Medicine updateMed(Medicine medicine) {
        Medicine med1=getMedicineById(medicine.getMedId());

        med1.setArrivalDate(medicine.getArrivalDate());
        med1.setCompanyName(medicine.getCompanyName());
        med1.setExpiryDate(medicine.getExpiryDate());
        med1.setManufactureDate(medicine.getManufactureDate());
        med1.setMedicineName(medicine.getMedicineName());
        med1.setPrice(medicine.getPrice());
        med1.setRemainingQty(medicine.getRemainingQty());
        med1.setTotalQty(medicine.getTotalQty());

        medicine=medicineRepository.save(med1);
        return medicine ;
    }
}
