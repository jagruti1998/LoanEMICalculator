package com.app.controller;


import com.app.Request.LoanRequest;
import com.app.entity.Loan;
import com.app.service.LoanService;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class LoanController {

    @Autowired
    LoanService loanService;

    //createLoan
    @PostMapping("/loan")
    public Loan createLoan(@RequestBody LoanRequest loanRequest){

        return loanService.createLoan(loanRequest);
    }

    //getAllLoan
}
