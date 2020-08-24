package com.medicalProject.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer custId;

    private String custName;

    private int age;

    private String gender;

    private String doctor;

    private float totalBill;

    private float amtPaid;

    private float amtRemaining;


    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(value=TemporalType.DATE)
    private Date purchaseDate;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "cust_meds",
            joinColumns = @JoinColumn(name = "custId"),
            inverseJoinColumns=@JoinColumn(name = "medId")
    )
    private List<Medicine> medicines;
}
