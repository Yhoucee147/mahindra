package com.iapl.robots.config;

import com.iapl.robots.entities.Resource;
import com.iapl.robots.repos.ResourceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RobotRunner implements CommandLineRunner {

    private ResourceRepository resourceRepository;

    public RobotRunner(ResourceRepository resourceRepository) {
        this.resourceRepository = resourceRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Resource resource1 = new Resource();
        resource1.setResouceName("Water");
        resource1.setDescription("Water resource for Survivor");
        resourceRepository.save(resource1);
        Resource resource2 = new Resource();
        resource2.setResouceName("Food");
        resource2.setDescription("Food resource for Survivor");
        resourceRepository.save(resource2);
        Resource resource3 = new Resource();
        resource3.setResouceName("Medication");
        resource3.setDescription("Medication resource for Survivor");
        resourceRepository.save(resource3);
        Resource resource4 = new Resource();
        resource4.setResouceName("Ammunition");
        resource4.setDescription("Ammunition resource for Survivor");
        resourceRepository.save(resource4);
    }
}
