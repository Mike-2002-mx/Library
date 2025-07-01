package com.libraryproject.model;

import jakarta.persistence.*;

@Entity
@Table(name="librarians")
public class Librarian {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( nullable = false, unique = true)
    private Integer idLibrarian;

    @Column(nullable = false)
    private String librarianName;

    @Column(nullable = false)
    private String firstSurname;

    @Column(nullable = false)
    private String secondSurname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String phone;

    public Librarian() {
    }

    public Librarian(Integer idLibrarian, String librarianName, String firstSurname, String secondSurname, String email,
            String password, String phone) {
        this.idLibrarian = idLibrarian;
        this.librarianName = librarianName;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public Integer getIdLibrarian() {
        return idLibrarian;
    }

    public String getLibrarianName() {
        return librarianName;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public void setIdLibrarian(Integer idLibrarian) {
        this.idLibrarian = idLibrarian;
    }

    public void setLibrarianName(String librarianName) {
        this.librarianName = librarianName;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Librarian{");
        sb.append("idLibrarian=").append(idLibrarian);
        sb.append(", librarianName=").append(librarianName);
        sb.append(", firstSurname=").append(firstSurname);
        sb.append(", secondSurname=").append(secondSurname);
        sb.append(", email=").append(email);
        sb.append(", password=").append(password);
        sb.append(", phone=").append(phone);
        sb.append('}');
        return sb.toString();
    }
}
