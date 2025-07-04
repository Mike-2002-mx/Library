package com.libraryproject.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.libraryproject.model.Loan;
import com.libraryproject.service.LoansService;

@RestController
@RequestMapping("loans")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class LoansController {

    @Autowired
	private LoansService service;

    @GetMapping
	public List<Loan> getAll() {
		return service.getAll();
	}

    @GetMapping("{idLoan}")
    public ResponseEntity<Loan> getByIdLoan(@PathVariable int idLoan) {
		Loan loans = service.getByIdLoan(idLoan);
		return new ResponseEntity<>(loans, HttpStatus.OK);
	}

    @PostMapping
	public void register(@RequestBody Loan loans) {
		service.save(loans);
	}

	// @PutMapping("{idLoan}")
	// public ResponseEntity<?> update(@RequestBody Loan loans, @PathVariable int idLoan) {
	// 	try {
	// 		Loan auxLoan = service.getByIdLoan(idLoan);
	// 		loans.setIdLoan(auxLoan.getIdLoan());
	// 		service.save(loans);
	// 		return new ResponseEntity<>("Updated record", HttpStatus.OK);
	// 	}catch (NoSuchElementException e) {
	// 		return new ResponseEntity<>("The record with the control number provided is not found in the database", HttpStatus.NOT_FOUND);
	// 	}
	// }

	@DeleteMapping("{idLoan}")
	public void delete(@PathVariable int idLoan) {
		service.delete(idLoan);
	}
}
