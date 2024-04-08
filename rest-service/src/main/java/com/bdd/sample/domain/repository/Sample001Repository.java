package com.bdd.sample.domain.repository;

import com.bdd.sample.domain.model.Sample001;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Sample001Repository extends JpaRepository<Sample001, String>{
    List<Sample001>findByText(String name);
    List<Sample001>findByTextIgnoreCaseStartingWith(String name);

}

