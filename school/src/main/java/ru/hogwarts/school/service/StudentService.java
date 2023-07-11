package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {
   private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public Student findStudent(long id){
        return studentRepository.findById(id).get();
    }

    public Student changeStudent(Student student){
        return studentRepository.save(student);
    }

    public void removeStudent(long id){
        studentRepository.deleteById(id);
    }

    public Collection<Student> allStudent(){
        return studentRepository.findAll();
    }

    public Collection<Student> getStudentForAge(long age){
        return studentRepository.findAll().stream()
                .filter(e -> e.getAge() == age)
                .collect(Collectors.toList());
    }

}
