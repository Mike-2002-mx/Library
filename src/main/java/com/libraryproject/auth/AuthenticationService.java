package com.libraryproject.auth;



import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.libraryproject.model.User.UserType;
import com.libraryproject.dto.LoginUserDTO;
import com.libraryproject.dto.RegisterUserDTO;
import com.libraryproject.model.User;
import com.libraryproject.repository.UserRepository;
@Service
public class AuthenticationService  {
    
    private final UserRepository userRepository;
    
    private final PasswordEncoder passwordEncoder;
    
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
        UserRepository userRepository,
        AuthenticationManager authenticationManager,
        PasswordEncoder passwordEncoder
    ) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(RegisterUserDTO input){
        User user = new User();
        user.setUserName(input.getUserName());
        user.setFirstSurname(input.getFirstSurmane());
        user.setSecondSurname(input.getSecondSurname());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setPhone(input.getPhone());
        user.setUserType(UserType.fromString(input.getUserType()));
        user.setActive(true);
        

        return userRepository.save(user);
    }

    public User authenticate(LoginUserDTO input) {

        UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                );
        
        System.out.println("Servicio de autenticación: " + user.toString());

        authenticationManager.authenticate(
                user
        );
        

        return userRepository.findByEmail(input.getEmail())
                .orElseThrow();
    }

}
