package com.iapl.robots.service;

import com.iapl.robots.entities.Resource;
import com.iapl.robots.exception.NoSuchResourceException;
import com.iapl.robots.repos.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public Resource createResource(Resource resource) {
        return resourceRepository.save(resource);
    }

    public Resource getResource(long resourceId) throws NoSuchResourceException {
        Optional<Resource> resource = resourceRepository.findById(resourceId);
        if (!resource.isPresent()) {
            throw new NoSuchResourceException("No Resource for Provided Id");
        }
        return resource.get();
    }

    public List<Resource> getAllResources() {
        return resourceRepository.findAll();
    }

}
