package com.libraryproject.dto;


public class UserDTO {

    private String userName;

    private String firstSurname;

    private String secondSurname;

    private String email;

    private String password;

    private String phone;

    private UserType userType;

    private boolean active;

    public UserDTO() {
    }

    public UserDTO(String userName, String firstSurname, String secondSurname, String email, String password,
            String phone, UserType userType, boolean active) {
        this.userName = userName;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userType = userType;
        this.active = active;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public enum UserType {
        student,
        professor
    }

    @Override
    public String toString() {
        return "User [userName=" + userName + ", firstSurname=" + firstSurname
                + ", secondSurname=" + secondSurname + ", email=" + email + ", password=" + password + ", phone="
                + phone + ", userType=" + userType + ", active=" + active + "]";
    }
}