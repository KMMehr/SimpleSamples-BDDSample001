package com.bdd.sample.domain.service.impl;

import com.bdd.sample.domain.repository.Sample001Repository;
import com.bdd.sample.domain.service.Sample001Service;
import com.bdd.sample.domain.service.exception.Sample001NotFoundExecption;
import com.bdd.sample.domain.model.Sample001;
import com.bdd.sample.domain.resource.data.Sample001DC;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
//@Transactional(readOnly = true)
public class Sample001ServiceImpl implements Sample001Service {

    private final Sample001Repository sample001Repository;

    public Sample001ServiceImpl(Sample001Repository sample001Repository) {
        this.sample001Repository = sample001Repository;
        //authentication
    }

    @Transactional(transactionManager = "bddSampleTransactionManager")
    public Sample001 update(Sample001 sample001) {
        return this.sample001Repository.save(sample001);
    }

    @Transactional(transactionManager = "bddSampleTransactionManager")
//    @PreAuthorize("hasPermission(0, '', 'import-base-data-excel')")
    public Sample001 create(Sample001DC request) {
        Sample001 sample001 = Sample001.fromSample001Request(request);
        return this.sample001Repository.save(sample001);
    }
    @Transactional(transactionManager = "bddSampleTransactionManager")
//    @PreAuthorize("hasPermission(#id, '', 'import-base-data-excel')")
    public void delete(String id) {
        final Optional<Sample001> sample001 = this.sample001Repository.findById(id);
        sample001.ifPresent(this.sample001Repository::delete);
    }

    @Transactional(transactionManager = "bddSampleTransactionManager", readOnly = true)
//    @PreAuthorize("hasPermission(0, '', 'view-agenda')")
    public List<Sample001>findAll() {

        return this.sample001Repository.findAll();   }

    @Transactional(transactionManager = "bddSampleTransactionManager", readOnly = true)
    public List<Sample001>findByText(String name) {
        return this.sample001Repository.findByText(name);
    }

    @Transactional(transactionManager = "bddSampleTransactionManager", readOnly = true)
    public List<Sample001>findByTextStartingWith(String name) {
        return this.sample001Repository.findByTextIgnoreCaseStartingWith(name);
    }

    @Transactional(transactionManager = "bddSampleTransactionManager" , readOnly = true)
    public Sample001 findOne(String id) {
        final Optional<Sample001> sample001 = this.sample001Repository.findById(id);
        if (sample001.isPresent()) {
            return sample001.get();
        } else {
            throw new Sample001NotFoundExecption(id);
        }
    }
    @Transactional(transactionManager = "bddSampleTransactionManager")
    public void deleteAll() {
        this.sample001Repository.deleteAll();
    }
}