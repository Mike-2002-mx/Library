package com.libraryproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraryproject.model.Collection;

public interface CollectionRepository extends JpaRepository<Collection, Integer> {


}
