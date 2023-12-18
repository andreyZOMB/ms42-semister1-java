package com.example.monitoring_lab_work_completion.controller;

import com.example.monitoring_lab_work_completion.entity.DisciplineEntity;
import com.example.monitoring_lab_work_completion.service.DisciplineService;
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
public class DisciplineController {

    private final DisciplineService disciplineService;

    @GetMapping("/disciplines")
    public ResponseEntity<List<DisciplineEntity>> showDisciplines() {
        return new ResponseEntity<>(disciplineService.getDisciplines(), HttpStatus.OK);
    }

    @GetMapping("/disciplines/{id}")
    public ResponseEntity<DisciplineEntity> showDiscipline(@PathVariable Long id) {
        return new ResponseEntity<>(disciplineService.getDiscipline(id), HttpStatus.OK);
    }

    @PostMapping("/disciplines")
    public ResponseEntity<DisciplineEntity> createDiscipline(@RequestBody DisciplineEntity discipline) {
        disciplineService.createOrUpdateDiscipline(0L, discipline);
        return new ResponseEntity<>(discipline, HttpStatus.OK);
    }

    @PutMapping("/disciplines/{id}")
    public ResponseEntity<DisciplineEntity> updateDiscipline(@PathVariable Long id, @RequestBody DisciplineEntity discipline) {
        disciplineService.createOrUpdateDiscipline(id, discipline);
        return new ResponseEntity<>(discipline, HttpStatus.OK);
    }

    @DeleteMapping("/disciplines/{id}")
    public ResponseEntity<DisciplineEntity> deleteDiscipline(@PathVariable Long id) {
        disciplineService.deleteDiscipline(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
