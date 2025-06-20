package com.libraryproject.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraryproject.model.Collection;
import com.libraryproject.repository.CollectionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CollectionService {
    @Autowired
    private CollectionRepository repo;

    public List<Collection> getAll(){
        return repo.findAll();
    }

    public void save (Collection collections){
        repo.save(collections);
    }

    public Collection getByIdCollection(Integer idCollection){
        return repo.findById(idCollection).get();
    }

    public void delete (Integer idCollection){
        repo.deleteById(idCollection);
    }

}
