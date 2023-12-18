package com.example.monitoring_lab_work_completion.service;

import com.example.monitoring_lab_work_completion.entity.AssignmentEntity;
import com.example.monitoring_lab_work_completion.repository.AssignmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;

    public List<AssignmentEntity> getAssignments() {
        return assignmentRepository.findAll();
    }

    public AssignmentEntity getAssigment(Long id) {
        return assignmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not exist!"));
    }

    public void createOrUpdateAssigment(Long id, AssignmentEntity assignment) {
        assignment.setId(id);
        assignmentRepository.save(assignment);
    }

    public void deleteAssigment(Long id) {
        assignmentRepository.deleteById(id);
    }
}
