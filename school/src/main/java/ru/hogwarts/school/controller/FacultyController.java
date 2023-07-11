package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;


import java.util.Collection;

@RestController
@RequestMapping("faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping()
    public Collection<Faculty> allFaculty() {
        return facultyService.allFaculty();
    }

    @GetMapping("{id}")
    public Faculty findFaculty(@PathVariable long id) {
        return facultyService.findFaculty(id);
    }

    @PostMapping()
    public Faculty addFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @PutMapping()
    public Faculty changeFaculty(Faculty faculty) {
        return facultyService.changeFaculty(faculty);
    }

    @DeleteMapping("{id}")
    public void removeFaculty(@PathVariable long id) {
        facultyService.removeFaculty(id);
    }

    @GetMapping("color/{color}")
    public Collection<Faculty> getFacultyForColor(@PathVariable String color) {
        return facultyService.getFacultyForColor(color);
    }
}
