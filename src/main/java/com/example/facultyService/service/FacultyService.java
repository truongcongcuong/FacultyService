package com.example.facultyService.service;

import com.example.facultyService.entity.Faculty;
import com.example.facultyService.repo.FacultyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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


    @Cacheable("faculty")
    public Faculty findFacultyById(int id){
        log.info("find Faculty by id : "+id);
        return facultyRepository.findById(id).get();
    }


    @CacheEvict("faculty")
    public void clearFacultyById(int id){
    }


    @CacheEvict(value = "faculty", allEntries = true)
    public void clearFaculties(){
    }


    @CachePut(value = "faculty")
    public Faculty putFaculties(int id){
        Faculty faculty = facultyRepository.findById(id).get();
        faculty.setFacultyName("update put cache");
        return faculty;
    }
}
