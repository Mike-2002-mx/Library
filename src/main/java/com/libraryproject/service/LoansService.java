package com.libraryproject.service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryproject.dto.LoansResponseDTO;
import com.libraryproject.model.Loans;
import com.libraryproject.repository.LoansRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LoansService {
    @Autowired
    private LoansRepository repo;

    public List<Loans> getAll() {
		return repo.findAll();
	}

	public void save(Loans loans) {
		repo.save(loans);
	}

	public Loans getByIdLoan(Integer idLoan) {
		return repo.findById(idLoan).get();
	}

	public void delete(Integer idLoan) {
		repo.deleteById(idLoan);
	}

	public List<LoansResponseDTO> getAllAsDTO() {
		List<Loans> loans = repo.findAll();

		return loans.stream().map(loan -> {
			LoansResponseDTO dto = new LoansResponseDTO();
			dto.setIdLoan(loan.getIdLoan());
			dto.setLoanDate(loan.getLoanDate());
			dto.setEstimatedReturnDate(loan.getEstimatedReturnDate());
			dto.setRealReturnDate(loan.getRealReturnDate());
			dto.setLoanStatus(loan.getLoanStatus().toString());
			dto.setBookTitle(loan.getBook().getTitle());
			dto.setUserName(loan.getUser().getUserName()); // Ajusta si el campo no se llama "name"
			return dto;
		}).collect(Collectors.toList());
	}
}
