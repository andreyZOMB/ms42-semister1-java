package com.example.monitoring_lab_work_completion.controller;

import com.example.monitoring_lab_work_completion.entity.ScoreEntity;
import com.example.monitoring_lab_work_completion.service.ScoreService;
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
public class ScoreController {

    private final ScoreService scoreService;

    @GetMapping("/scores")
    public ResponseEntity<List<ScoreEntity>> shows() {
        return new ResponseEntity<>(scoreService.getScores(), HttpStatus.OK);
    }

    @GetMapping("/scores/{id}")
    public ResponseEntity<ScoreEntity> show(@PathVariable Long id) {
        return new ResponseEntity<>(scoreService.getScore(id), HttpStatus.OK);
    }

    @PostMapping("/scores")
    public ResponseEntity<ScoreEntity> create(@RequestBody ScoreEntity score) {
        scoreService.createOrUpdateScore(0L, score);
        return new ResponseEntity<>(score, HttpStatus.OK);
    }

    @PutMapping("/scores/{id}")
    public ResponseEntity<ScoreEntity> update(@PathVariable Long id, @RequestBody ScoreEntity score) {
        scoreService.createOrUpdateScore(id, score);
        return new ResponseEntity<>(score, HttpStatus.OK);
    }

    @DeleteMapping("/scores/{id}")
    public ResponseEntity<ScoreEntity> delete(@PathVariable Long id) {
        scoreService.deleteScore(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
