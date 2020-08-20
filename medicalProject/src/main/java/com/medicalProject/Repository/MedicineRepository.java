package com.medicalProject.Repository;

import com.medicalProject.Model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine,Integer> {
}
