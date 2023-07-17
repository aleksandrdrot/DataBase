package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty){
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id){
        return facultyRepository.findById(id).get();
    }

    public Faculty changeFaculty(Faculty faculty){
        return facultyRepository.save(faculty);
    }

    public void removeFaculty(long id){
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> allFaculty(){
        return facultyRepository.findAll();
    }

    public Collection<Faculty> findFacultiesByNameOrColor(String name, String color){
        return facultyRepository.findFacultiesByNameIgnoreCaseOrColorIgnoreCase(name, color);
    }

    public Faculty findFacultiesByStudent(String name){
        return facultyRepository.findFacultiesByStudentsIgnoreCase_name(name);
    }
}
