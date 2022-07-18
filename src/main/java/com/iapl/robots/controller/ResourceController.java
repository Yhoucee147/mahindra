package com.iapl.robots.controller;

import com.iapl.robots.entities.Resource;
import com.iapl.robots.exception.NoSuchResourceException;
import com.iapl.robots.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @PostMapping("/createResource")
    public Resource createResource(@RequestBody Resource resource) {
        return resourceService.createResource(resource);
    }

    @GetMapping("/getResource")
    public Resource getResource(@RequestParam long resourceId) throws NoSuchResourceException {
        return resourceService.getResource(resourceId);
    }

    @GetMapping("/getAllResources")
    public List<Resource> getAllResources() {
        return resourceService.getAllResources();
    }

}
