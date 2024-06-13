package com.app.service;

import com.app.Request.LoanRequest;
import com.app.entity.Loan;
import com.app.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LoanService {

    @Autowired
    LoanRepository loanRepository;

    public Loan createLoan(LoanRequest loanRequest) {
        String role = loanRepository.findRoleByUsername(loanRequest.getAdminUsername());

        if (role.equals("admin")) {
            double interestRate = 10.0;  // Fixed interest rate
            double interest = loanRequest.getPrincipalAmount() * interestRate * loanRequest.getTenure() / 100;
            double totalAmount = loanRequest.getPrincipalAmount() + interest;
            double emiAmount = totalAmount / (loanRequest.getTenure() * 12);

            Loan loan = new Loan();
            loan.setAdminUsername(loanRequest.getAdminUsername());
            loan.setCustomerUsername(loanRequest.getCustomerUsername());
            loan.setPrincipalAmount(loanRequest.getPrincipalAmount());
            loan.setTenure(loanRequest.getTenure());
            loan.setInterestRate(interestRate);
            loan.setTotalAmount(totalAmount);
            loan.setEmiAmount(emiAmount);
            loan.setStartdate(LocalDate.now());
            loan.setEndDate(LocalDate.now().plusMonths(loanRequest.getTenure() * 12));

            return loanRepository.save(loan);
        } else {
            throw new RuntimeException("Only admins can create loans");
        }
    }
}
