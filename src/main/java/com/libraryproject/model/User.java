package com.libraryproject.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Arrays;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser")
    private int idUser;

    @Column(name = "username")
    private String userName;

    @Column(name = "firstsurname")
    private String firstSurname;

    @Column(name = "secondsurname")
    private String secondSurname;

    @Column(name = "email", unique = true, length = 150)
    private String email;

    @Column(name = "password", length = 255)
    private String password;

    @Column(name = "phone", length = 20)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "usertype", length = 15)
    private UserType userType;

    @Column(name = "active")
    private boolean active;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + userType.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }



    public User() {

    }

    public User(int idUser, String userName, String firstSurname, String secondSurname, String email, String password,
            String phone, UserType userType, boolean active) {
        this.idUser = idUser;
        this.userName = userName;
        this.firstSurname = firstSurname;
        this.secondSurname = secondSurname;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userType = userType;
        this.active = active;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

    // public String getPassword() {
    //     return password;
    // }

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
        STUDENT,
        PROFESSOR;

        public static UserType fromString(String userType) {
            if (userType == null) return null;
            return Arrays.stream(UserType.values())
                .filter(role -> role.name().equalsIgnoreCase(userType.trim()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Tipo de usuario inválido: " + userType));
        }
    }

    @Override
    public String toString() {
        return "User [idUser=" + idUser + ", userName=" + userName + ", firstSurname=" + firstSurname
                + ", secondSurname=" + secondSurname + ", email=" + email + ", password=" + password + ", phone="
                + phone + ", userType=" + userType + ", active=" + active + "]";
    }

}