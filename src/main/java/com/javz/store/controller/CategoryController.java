package com.javz.store.controller;
;
import com.javz.store.model.Category;
import com.javz.store.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICategoryService service;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        List<Category> list = service.getAll();
        return  new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        return  new ResponseEntity<>(service.create(category),HttpStatus.CREATED);
    }

}
