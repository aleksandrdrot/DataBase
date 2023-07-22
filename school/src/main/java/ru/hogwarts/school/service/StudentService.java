package ru.hogwarts.school.service;

import org.hibernate.stat.CollectionStatistics;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.repository.countStudent;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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

    public Collection<Student> findByAgeBetween(int minAge, int maxAge){
        return studentRepository.findByAgeBetween(minAge, maxAge);
    }

    public Collection<Student> findStudentsByFaculty(String name){
        return studentRepository.findStudentsByFacultyIgnoreCase_name(name);
    }

    public Integer countAllStudent(){
        return studentRepository.countAllStudent();
    }

    public Integer avgAgeStudent(){
        return studentRepository.avgAgeStudent();
    }

    public List<countStudent> idSortStudent(){
        return studentRepository.idSortStudent();
    }

}
