package com.libraryproject.dto;

public class LibrarianDTO {
    
    private String librarianName;
    private String firstSurname;
    private String secondSurname;
    private String email;
    private String password;
    private String phone;

    public String getLibrarianName() {
        return librarianName;
    }

    public void setLibrarianName(String librarianName) {
        this.librarianName = librarianName;
    }

    public String getFirstSurname() {
        return firstSurname;
    }

    public void setFirstSurname(String firstSurname) {
        this.firstSurname = firstSurname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LibrarianDTO() {
    }

    public LibrarianDTO(String librarianName, String firstSurname, String secondSurname, String email, String password,
            String phone) {
        this.librarianName = librarianName;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }
    
    @Override
    public String toString() {
        return "LibrarianDTO [librarianName=" + librarianName + ", firstSurname=" + firstSurname + ", secondSurname="
                + secondSurname + ", email=" + email + ", password=" + password + ", phone=" + phone + "]";
    }
}
