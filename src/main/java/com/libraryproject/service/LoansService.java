package com.libraryproject.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryproject.model.Loan;
import com.libraryproject.repository.LoansRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LoansService {
    @Autowired
    private LoansRepository repo;

    public List<Loan> getAll() {
		return repo.findAll();
	}

	public void save(Loan loans) {
		repo.save(loans);
	}

	public Loan getByIdLoan(Integer idLoan) {
		return repo.findById(idLoan).get();
	}

	public void delete(Integer idLoan) {
		repo.deleteById(idLoan);
	}

}
