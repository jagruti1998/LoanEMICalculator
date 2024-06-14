package com.app.controller;


import com.app.Request.LoanRequest;
import com.app.entity.Loan;
import com.app.service.LoanService;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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

    //getLoan
    @GetMapping("/{loanId}")
    public Loan getLoan(@PathVariable int loanId) {
        return loanService.getLoan(loanId);
    }

    @GetMapping("/admin/all")
    public List<Loan> getAllLoans() {
        return loanService.getAllLoans();
    }
}
