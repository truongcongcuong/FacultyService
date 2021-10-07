package com.example.facultyService.controller;

import com.example.facultyService.entity.Faculty;
import com.example.facultyService.service.FacultyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/faculty")
@Slf4j
public class FacultyController {

    @Value("${messenger.author}")
    private String hello;

    @Autowired
    private FacultyService facultyService;

    @PostMapping("/")
    public Faculty saveFalcuty(@RequestBody @Valid Faculty faculty){
        log.info("controller faculty - save faculty");
        return facultyService.saveFaculty(faculty);
    }

    @GetMapping("/{id}")
    public Faculty findById(@PathVariable("id") Integer id){
        log.info("controller faculty - find faculty by id : "+id);
        return facultyService.findFacultyById(id);
    }

    @GetMapping("/")
    public String hello(){
        return hello;
    }
}
