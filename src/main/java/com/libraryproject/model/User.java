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
import lombok.Data;


@Data
@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer idUser;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name") //Apellidos
    private String lastName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "password")
    private String password;

    @Column(name = "address")
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type", length = 15)
    private UserType userType;

    @Column(name = "active")
    private boolean active;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + userType.name()));
    }

    @Override
    public String getUsername() {
        return phone;
    }

    @Override
    public String getPassword() {
        return password;
    }


    public enum UserType {
        BIBLIOTECARIO,
        LECTOR;

        public static UserType fromString(String userType) {
            if (userType == null) return null;
            return Arrays.stream(UserType.values())
                .filter(role -> role.name().equalsIgnoreCase(userType.trim()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Tipo de usuario inválido: " + userType));
        }
    }


}