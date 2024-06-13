package com.app.Request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class LoanRequest {

    private String customerUsername;
    private String adminUsername;
    private Double principalAmount;
    private int tenure;
}

