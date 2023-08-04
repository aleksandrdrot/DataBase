package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    Logger log = LoggerFactory.getLogger(FacultyService.class);

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty){
        log.info( "createFaculty = OK!");
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id){
        log.info( "findFaculty = OK!");
        return facultyRepository.findById(id).get();
    }

    public Faculty changeFaculty(Faculty faculty){
        log.info( "changeFaculty = OK!");
        return facultyRepository.save(faculty);
    }

    public void removeFaculty(long id){
        facultyRepository.deleteById(id);
        log.info( "removeFaculty = OK!");
    }

    public Collection<Faculty> allFaculty(){
        log.info( "allFaculty = OK!");
        return facultyRepository.findAll();
    }

    public Collection<Faculty> findFacultiesByNameOrColor(String name, String color){
        log.info( "findFacultiesByNameOrColor = OK!");
        return facultyRepository.findFacultiesByNameIgnoreCaseOrColorIgnoreCase(name, color);
    }

    public Faculty findFacultiesByStudent(String name){
        log.info( "findFacultiesByStudent = OK!");
        return facultyRepository.findFacultiesByStudentsIgnoreCase_name(name);
    }
}
