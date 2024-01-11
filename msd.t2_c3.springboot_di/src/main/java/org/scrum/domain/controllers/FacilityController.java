package org.scrum.domain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.scrum.domain.project.Facility;
import org.scrum.domain.project.dto.FacilityDto;
import org.scrum.domain.services.servicesImpl.FacilityServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/facilities")
public class FacilityController {

    private final FacilityServiceImpl facilityService;

    @Autowired
    public FacilityController(FacilityServiceImpl facilityService) {
        this.facilityService = facilityService;
    }

    @GetMapping
    public ResponseEntity<List<Facility>> getAllFacilities() {
        List<Facility> facilities = facilityService.getAll();
        return ResponseEntity.ok(facilities);
    }

    @PostMapping(value = "/addFacility", consumes = "application/json")
    public ResponseEntity<Facility> addFacility(@RequestBody FacilityDto facilityDto) {
        Facility newFacility = facilityService.addFacility(facilityDto);
        return ResponseEntity.ok(newFacility);
    }
}
