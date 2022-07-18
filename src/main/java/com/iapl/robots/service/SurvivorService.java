package com.iapl.robots.service;

import com.iapl.robots.entities.Survivor;
import com.iapl.robots.exception.NoSuchSurvivorException;
import com.iapl.robots.pojos.PercentageSurvivorResponse;
import com.iapl.robots.pojos.UpdateSurvivorLocationRequest;
import com.iapl.robots.repos.SurvivorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class SurvivorService {

    @Autowired
    private SurvivorRepository survivorRepository;

    public Survivor createSurvivor(Survivor survivor) {
        return survivorRepository.save(survivor);
    }

    public Survivor getSurvivor(long survivorId) throws NoSuchSurvivorException {
        Optional<Survivor> survivor = survivorRepository.findById(survivorId);
        if (!survivor.isPresent()) {
            throw new NoSuchSurvivorException("No Survivor for Provided Id");
        }
        return survivor.get();
    }

    public Survivor updateSurvivorLocation(UpdateSurvivorLocationRequest updateSurvivorLocationRequest)
            throws NoSuchSurvivorException {
        Optional<Survivor> survivor = survivorRepository.findById(updateSurvivorLocationRequest.getSurvivorId());
        if (!survivor.isPresent()) {
            throw new NoSuchSurvivorException("No Survivor for Provided Id");
        }
        Survivor surv = survivor.get();
        surv.setLastLocation(updateSurvivorLocationRequest.getLocation());
        return survivorRepository.save(surv);
    }

    public Survivor flagSurvivorAsInfected(long survivorId) throws NoSuchSurvivorException {
        Survivor survivor = getSurvivor(survivorId);
        survivor.setInfected(Boolean.TRUE);
        return survivorRepository.save(survivor);
    }

    public List<Survivor> getSurvivorByInfectionStatus(boolean isInfected) {
        return survivorRepository.findByIsInfected(isInfected);
    }

    public PercentageSurvivorResponse getSurvivorPercentageByInfectionStatus(boolean isInfected) {
        long totalSurvivorCount = survivorRepository.count();
        long infectedStatusCount = survivorRepository.findByIsInfected(isInfected).size();
        PercentageSurvivorResponse response = new PercentageSurvivorResponse();
        response.setPercentage(((double)(infectedStatusCount/totalSurvivorCount)*100));
        return response;
    }

}
