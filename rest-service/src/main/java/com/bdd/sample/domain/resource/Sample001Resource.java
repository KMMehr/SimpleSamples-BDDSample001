package com.bdd.sample.domain.resource;

import com.bdd.sample.domain.model.Sample001;
import com.bdd.sample.domain.service.impl.Sample001ServiceImpl;
import com.bdd.sample.domain.resource.data.Sample001DC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/bddSample/sample001")
@CrossOrigin(origins = "*" ,allowedHeaders = "*")
public class Sample001Resource {

    private final Sample001ServiceImpl sample001ServiceImpl;

    public Sample001Resource(Sample001ServiceImpl sample001ServiceImpl)   {
        this.sample001ServiceImpl = sample001ServiceImpl;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Sample001> findOne(@PathVariable("id") String id){
        return ResponseEntity.ok(this.sample001ServiceImpl.findOne(id));
    }

    @GetMapping
    public ResponseEntity<List<Sample001>> findAll() throws Exception {
        List<Sample001> aList = this.sample001ServiceImpl.findAll();
        return ResponseEntity.ok(aList);
    }

    @PostMapping
    public ResponseEntity<Sample001> newSample001(@RequestBody Sample001DC sample001DC){
        ResponseEntity<Sample001> aResponseEntity=new ResponseEntity<Sample001>(this.sample001ServiceImpl.create(sample001DC), HttpStatus.CREATED);
        return aResponseEntity;
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeSample001(@PathVariable("id") String id){
    }

    @DeleteMapping("/delete-all")
    public void removeAllSample001s(){
        this.sample001ServiceImpl.deleteAll();
    }



    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Sample001> updateSample001(@PathVariable("id") String id, Sample001DC sample001DC) throws Exception {
        throw  new Exception("NotImplementedException");
    }

    @GetMapping("/query")
    public ResponseEntity<List<Sample001>> findByTextStartingWith(@RequestParam("name") String name){
        return ResponseEntity.ok(this.sample001ServiceImpl.findByTextStartingWith(name));
    }

}