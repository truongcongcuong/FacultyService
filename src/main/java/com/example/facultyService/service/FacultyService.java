package com.example.facultyService.service;

import com.example.facultyService.entity.Faculty;
import com.example.facultyService.repo.FacultyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    public Faculty saveFaculty(Faculty faculty){
        log.info("save Faculty");
        return facultyRepository.save(faculty);
    }

    public Faculty findFacultyById(int id){
        log.info("find Faculty by id : "+id);
        return facultyRepository.findById(id).get();
    }


    public Faculty findFacultyThrowingException() throws Exception {
        throw new Exception("Exception In Falcuty");
    }
}
