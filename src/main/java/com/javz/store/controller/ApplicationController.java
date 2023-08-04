package com.javz.store.controller;

import com.javz.store.model.Application;
import com.javz.store.model.Category;
import com.javz.store.service.IApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/applications")
public class ApplicationController {
    @Autowired
    private IApplicationService service;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<List<Application>> getAll() {
        List<Application> appList = service.getAll();
        return  new ResponseEntity<>(appList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Application> createApplication(@RequestBody Application application){
        return  new ResponseEntity<>(service.create(application),HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/category/{id}")
    public ResponseEntity<List<Application>> getAppsByCategory(@PathVariable("id") Long id){
        return  new ResponseEntity<>(service.getApplicationsByCategory(id), HttpStatus.OK);
    }
}
