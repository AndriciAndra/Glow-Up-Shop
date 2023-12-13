package org.scrum.domain.controllers;

import org.scrum.domain.project.Facility;
import org.scrum.domain.project.dto.FacilityDto;
import org.scrum.domain.services.servicesImpl.FacilityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/facilities")
public class FacilityController {
    @Autowired
    private FacilityServiceImpl FacilityServiceImpl;

    @GetMapping("/")
    public List<Facility> getAllFacilities() {
        return FacilityServiceImpl.getAll();
    }

    @PostMapping(value = "/addFacility", consumes = "application/json")
    public Facility addFacility(@RequestBody FacilityDto facility) {
        return FacilityServiceImpl.addFacility(facility);
    }
}
