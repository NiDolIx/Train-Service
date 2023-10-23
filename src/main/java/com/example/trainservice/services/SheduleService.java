package com.example.trainservice.services;

import com.example.trainservice.models.Shedule;
import com.example.trainservice.repository.SheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SheduleService {
    private final SheduleRepository sheduleRepository;

    @Autowired
    public SheduleService(SheduleRepository sheduleRepository) {
        this.sheduleRepository = sheduleRepository;
    }

    public List<Shedule> getAllShedule(Long idRoute, String trainName){
        return sheduleRepository.getAllShedule(idRoute, trainName);
    }
}
