package org.scrum.domain.controllers;

import org.scrum.domain.project.Facility;
import org.scrum.domain.services.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facilities")
public class FacilityController {
    @Autowired
    private FacilityService FacilityService;

    @GetMapping("/")
    public List<Facility> getAllFacilities() {
        return FacilityService.getAllFacilities();
    }

    @PostMapping(value = "/addFacility", consumes = "application/json")
    public Facility addFacility(@RequestBody Facility facility) {
        return FacilityService.addFacility(facility);
    }
}
