package com.libraryproject.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libraryproject.dto.LoginUserDTO;
import com.libraryproject.dto.RegisterUserDTO;
import com.libraryproject.model.User;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    
    private final JwtService jwtService;
    
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDTO registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDTO loginUserDto) {
        System.out.println("loginUserDto: " + loginUserDto.toString());
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        System.out.println( "authenticatedUser: " +authenticatedUser.toString());


        String jwtToken = jwtService.generateToken(authenticatedUser);


        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwtToken);
        loginResponse.setExpiresIn(jwtService.getExpirationTime());
        System.out.println(loginResponse);

        return ResponseEntity.ok(loginResponse);
    }

}
