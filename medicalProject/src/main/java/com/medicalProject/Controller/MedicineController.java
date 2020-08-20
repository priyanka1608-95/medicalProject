package com.medicalProject.Controller;

import com.medicalProject.Model.ErrorResponse;
import com.medicalProject.Model.Medicine;
import com.medicalProject.Service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicines")
public class MedicineController {

    @Autowired
    MedicineService medicineService;

    @PostMapping("/addMedicine")
    public ResponseEntity<?> addMedicines(@RequestBody Medicine medicine)
    {
        Medicine meds= medicineService.addMedicine(medicine);
        if(meds !=null)
            return new ResponseEntity<>(meds,HttpStatus.OK);
        else {
            ErrorResponse errorResponse=new ErrorResponse();
            errorResponse.setMessage("Cannot add medicines.Try again.");
            errorResponse.setStatus("FAILED");
            return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
        }
    }


}
