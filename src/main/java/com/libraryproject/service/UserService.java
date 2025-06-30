package com.libraryproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryproject.dto.UserLectorRequest;
import com.libraryproject.dto.UserLectorResponse;
import com.libraryproject.model.User;
import com.libraryproject.model.User.UserType;
import com.libraryproject.repository.UserRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public User saveLector(UserLectorRequest request){
        User lector = new User();
        lector.setActive(true);
        lector.setAddress(request.getAddress());
        lector.setLastName(request.getLastName());
        lector.setName(request.getName());
        lector.setPhone(request.getPhone());
        lector.setUserType(UserType.LECTOR);
        lector.setPassword(request.getPassword());
        User saveLector = userRepository.save(lector);        
        return saveLector;
    }

    public User getByIdUser(Integer idUser){
        return userRepository.findById(idUser).get();
    }
}