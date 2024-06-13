package com.app.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String adminUsername;
    private String customerUsername;
    private Double principalAmount;
    private int tenure;
    private Double interestRate;
    private Double totalAmount;
    private Double emiAmount;
    private LocalDate startdate;
    private LocalDate endDate;

    @OneToMany
    private List<Emi> emis;
}
