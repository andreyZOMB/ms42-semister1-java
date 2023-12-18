package com.example.monitoring_lab_work_completion.service;

import com.example.monitoring_lab_work_completion.entity.DisciplineEntity;
import com.example.monitoring_lab_work_completion.repository.DisciplineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DisciplineService {

    private final DisciplineRepository disciplineRepository;

    public List<DisciplineEntity> getDisciplines() {
        return disciplineRepository.findAll();
    }

    public DisciplineEntity getDiscipline(Long id) {
        return disciplineRepository.findById(id).orElseThrow(() -> new RuntimeException("Id not found!"));
    }

    public void createOrUpdateDiscipline(Long id,DisciplineEntity discipline) {
        discipline.setId(id);
        disciplineRepository.save(discipline);
    }

    public void deleteDiscipline(Long id) {
        disciplineRepository.deleteById(id);
    }
}
