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
@Table(name = "medicines")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer medId;

    private String medicineName;

    private String companyName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(value=TemporalType.DATE)
    private Date manufactureDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(value=TemporalType.DATE)
    private Date expiryDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Temporal(value=TemporalType.DATE)
    private Date arrivalDate;

    private float price;

    private int totalQty;

    private int remainingQty;

    private int purchasedQty;

    @ManyToMany(mappedBy = "medicines")
    @JsonBackReference
    private List<Customer> customers;

}
