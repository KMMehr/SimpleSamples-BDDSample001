package com.bdd.sample.domain.service;

import com.bdd.sample.domain.model.Sample001;
import com.bdd.sample.domain.resource.data.Sample001DC;

import java.util.List;


public interface Sample001Service {

    public Sample001 update(Sample001 sample001);

    public Sample001 create(Sample001DC request) ;

    public void delete(String id);

    public List<Sample001>findAll();

    public List<Sample001>findByText(String name);

    public List<Sample001>findByTextStartingWith(String name);

    public Sample001 findOne(String id) ;

    public void deleteAll();
}