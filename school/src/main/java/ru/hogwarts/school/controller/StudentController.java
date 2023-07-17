package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public Collection<Student> allStudent(){
        return studentService.allStudent();
    }

    @GetMapping("{id}")
    public Student findStudent(@PathVariable long id){
        return studentService.findStudent(id);
    }

    @PostMapping()
    public Student addStudent(Student student){
        return studentService.createStudent(student);
    }

    @PutMapping()
    public Student changeStudent(Student student){
        return studentService.changeStudent(student);
    }

    @DeleteMapping("{id}")
    public void removeStudent(@PathVariable long id){
        studentService.removeStudent(id);
    }

    @GetMapping("age/{minAge}/{maxAge}")
    public Collection<Student> findByAgeBetween(@PathVariable int minAge,@PathVariable int maxAge){
        return studentService.findByAgeBetween(minAge, maxAge);
    }
    @GetMapping("faculty/{name}")
    public Collection<Student> findStudentsByFaculty(@PathVariable String name){
        return studentService.findStudentsByFaculty(name);
    }

}
