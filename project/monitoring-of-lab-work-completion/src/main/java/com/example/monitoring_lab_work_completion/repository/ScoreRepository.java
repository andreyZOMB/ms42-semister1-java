package com.example.monitoring_lab_work_completion.repository;

import com.example.monitoring_lab_work_completion.entity.ScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreRepository extends JpaRepository<ScoreEntity, Long> {
}
