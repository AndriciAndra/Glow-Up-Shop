package org.scrum.domain.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.scrum.domain.project.dto.ItemDto;
import org.scrum.domain.services.FacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.scrum.domain.project.Facility;
import org.scrum.domain.project.dto.FacilityDto;
import org.scrum.domain.services.servicesImpl.FacilityServiceImpl;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/facilities")
public class FacilityController {

    private final FacilityService facilityService;

    @Autowired
    public FacilityController(FacilityServiceImpl facilityService) {
        this.facilityService = facilityService;
    }

    @GetMapping("/")
    public List<FacilityDto> getAllFacilities() {
        return facilityService.getAll();
    }

    @PostMapping("/addFacility")
    public Facility addFacility(@RequestParam("facility") String facilityJson,
                                @RequestParam("image") MultipartFile imageItem) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            FacilityDto facilityDto = objectMapper.readValue(facilityJson, FacilityDto.class);
            return facilityService.addFacility(imageItem, facilityDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
