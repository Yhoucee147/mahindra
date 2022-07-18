package com.iapl.robots.controller;

import com.iapl.robots.entities.Survivor;
import com.iapl.robots.exception.NoSuchSurvivorException;
import com.iapl.robots.pojos.PercentageSurvivorResponse;
import com.iapl.robots.pojos.UpdateSurvivorLocationRequest;
import com.iapl.robots.service.SurvivorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/survivor")
public class SurvivorController {

    @Autowired
    private SurvivorService survivorService;

    @PostMapping("/createSurvivor")
    public Survivor createSurvivor(@RequestBody Survivor survivor) {
        return survivorService.createSurvivor(survivor);
    }

    @GetMapping("/getSurvivor")
    public Survivor getSurvivor(@RequestParam long survivorId) throws NoSuchSurvivorException {
        return survivorService.getSurvivor(survivorId);
    }

    @PostMapping("/updateSurvivorLocation")
    public Survivor updateSurvivorLocation(@RequestBody UpdateSurvivorLocationRequest
                                                       updateSurvivorLocationRequest) throws NoSuchSurvivorException {
        return survivorService.updateSurvivorLocation(updateSurvivorLocationRequest);
    }

    @GetMapping("/flagSurvivorAsInfected")
    public Survivor flagSurvivorAsInfected(@RequestParam long survivorId) throws NoSuchSurvivorException {
        return survivorService.flagSurvivorAsInfected(survivorId);
    }

    @GetMapping("/getAllInfectedSurvivors")
    public List<Survivor> getAllInfectedSurvivors() {
        return survivorService.getSurvivorByInfectionStatus(Boolean.TRUE);
    }

    @GetMapping("/getAllUninfectedSurvivors")
    public List<Survivor> getAllUninfectedSurvivors() {
        return survivorService.getSurvivorByInfectionStatus(Boolean.FALSE);
    }

    @GetMapping("/getInfectedSurvivorsPercentage")
    public PercentageSurvivorResponse getInfectedSurvivorsPercentage() {
        return survivorService.getSurvivorPercentageByInfectionStatus(Boolean.TRUE);
    }

    @GetMapping("/getUnifectedSurvivorsPercentage")
    public PercentageSurvivorResponse getUninfectedSurvivorsPercentage() {
        return survivorService.getSurvivorPercentageByInfectionStatus(Boolean.FALSE);
    }

}
