package com.medicalProject.Controller;

import com.medicalProject.Model.ResponseModel;
import com.medicalProject.Model.Medicine;
import com.medicalProject.Service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            ResponseModel responseModel =new ResponseModel();
            responseModel.setMessage("Cannot add medicines.Try again.");
            responseModel.setStatus("FAILED");
            return new ResponseEntity<>(responseModel,HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delMedicine/{mId}")
    public void delMedicine(@PathVariable int mId)
    {
            medicineService.delMedicine(mId);
    }

    @PutMapping("/updateMed")
    public ResponseEntity<?> updateMedicine(@RequestBody Medicine medicine)
    {
            Medicine meds=medicineService.updateMed(medicine);
            if(meds !=null)
                return new ResponseEntity<>(meds,HttpStatus.OK);
            else {
                ResponseModel responseModel = new ResponseModel();
                responseModel.setMessage("Cannot update medicines.Try again.");
                responseModel.setStatus("FAILED");
                return new ResponseEntity<>(responseModel, HttpStatus.BAD_REQUEST);
            }

    }




}
