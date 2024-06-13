package com.app.repository;

import com.app.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {

    @Query("SELECT u.role FROM User u WHERE u.username = :adminUsername")
    String findRoleByUsername( String adminUsername);
}
