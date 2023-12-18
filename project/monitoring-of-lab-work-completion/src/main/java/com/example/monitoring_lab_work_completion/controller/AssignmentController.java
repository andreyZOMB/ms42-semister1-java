package com.example.monitoring_lab_work_completion.controller;

import com.example.monitoring_lab_work_completion.entity.AssignmentEntity;
import com.example.monitoring_lab_work_completion.service.AssignmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;

    @GetMapping("/assignments")
    public ResponseEntity<List<AssignmentEntity>> showAssignments() {
        return new ResponseEntity<>(assignmentService.getAssignments(), HttpStatus.OK);
    }

    @GetMapping("/assignments/{id}")
    public ResponseEntity<AssignmentEntity> showAssignment(@PathVariable Long id) {
        return new ResponseEntity<>(assignmentService.getAssigment(id), HttpStatus.OK);
    }

    @PostMapping("/assignments")
    public ResponseEntity<AssignmentEntity> createAssignment(@RequestBody AssignmentEntity assignment) {
        assignmentService.createOrUpdateAssigment(0L, assignment);
        return new ResponseEntity<>(assignment, HttpStatus.OK);
    }

    @PutMapping("/assignments/{id}")
    public ResponseEntity<AssignmentEntity> updateAssignment(@PathVariable Long id,@RequestBody AssignmentEntity assignment) {
        assignmentService.createOrUpdateAssigment(id, assignment);
        return new ResponseEntity<>(assignment, HttpStatus.OK);
    }

    @DeleteMapping("/assignments/{id}")
    public ResponseEntity<AssignmentEntity> deleteAssignment(@PathVariable Long id) {
        assignmentService.deleteAssigment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
