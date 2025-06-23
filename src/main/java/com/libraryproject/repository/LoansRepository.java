package com.libraryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryproject.model.Loan;

public interface LoansRepository extends JpaRepository<Loan, Integer> {

}
