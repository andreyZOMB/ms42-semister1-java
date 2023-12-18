package com.example.monitoring_lab_work_completion.service;

import com.example.monitoring_lab_work_completion.entity.StudentEntity;
import com.example.monitoring_lab_work_completion.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<StudentEntity> getStudents() {
        return studentRepository.findAll();
    }

    public StudentEntity getStudent(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not found!"));
    }

    public void createOrUpdateStudent(Long id,StudentEntity discipline) {
        discipline.setId(id);
        System.out.println(discipline);
        studentRepository.save(discipline);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
