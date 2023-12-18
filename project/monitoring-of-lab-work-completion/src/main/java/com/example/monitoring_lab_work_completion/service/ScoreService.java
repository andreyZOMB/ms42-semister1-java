package com.example.monitoring_lab_work_completion.service;

import com.example.monitoring_lab_work_completion.entity.ScoreEntity;
import com.example.monitoring_lab_work_completion.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScoreService {

    private final ScoreRepository scoreRepository;

    public List<ScoreEntity> getScores() {
        return scoreRepository.findAll();
    }

    public ScoreEntity getScore(Long id) {
        return scoreRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not found!"));
    }

    public void createOrUpdateScore(Long id,ScoreEntity discipline) {
        discipline.setId(id);
        scoreRepository.save(discipline);
    }

    public void deleteScore(Long id) {
        scoreRepository.deleteById(id);
    }
}
