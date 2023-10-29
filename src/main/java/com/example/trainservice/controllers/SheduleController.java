package com.example.trainservice.controllers;

import com.example.trainservice.models.Shedule;
import com.example.trainservice.services.SheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/shedule")
public class SheduleController {
    private final SheduleService sheduleService;

    @Autowired
    public SheduleController(SheduleService sheduleService) {
        this.sheduleService = sheduleService;
    }

    @GetMapping("/{idRoute}/{trainName}")
    public ResponseEntity <List<Shedule>> getAllShedule(
            @PathVariable("idRoute") Long idRoute,
            @PathVariable("trainName") String trainName
    ) {
        return ResponseEntity.ok(sheduleService.getAllShedule(idRoute, trainName));
    }
}
