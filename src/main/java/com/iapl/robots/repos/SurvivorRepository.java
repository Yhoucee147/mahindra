package com.iapl.robots.repos;

import com.iapl.robots.entities.Survivor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurvivorRepository extends JpaRepository<Survivor, Long> {

    public List<Survivor> findByIsInfected(Boolean isInfected);

}
