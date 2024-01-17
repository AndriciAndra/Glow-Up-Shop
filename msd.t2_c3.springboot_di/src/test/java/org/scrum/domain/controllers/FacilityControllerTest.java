package org.scrum.domain.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.scrum.domain.project.Facility;
import org.scrum.domain.project.dto.FacilityDto;
import org.scrum.domain.services.servicesImpl.FacilityServiceImpl;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class FacilityControllerTest {

    @InjectMocks
    private FacilityController facilityController;

    @Mock
    private FacilityServiceImpl facilityService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllFacilities() {
        List<Facility> mockFacilities = Arrays.asList(
                new Facility("Facility1", "Description1", 100.0, 2.5, "Category1", "photo1.jpg", true),
                new Facility("Facility2", "Description2", 150.0, 3.0, "Category2", "photo2.jpg", false)
        );
        when(facilityService.getAll()).thenReturn(mockFacilities);

        ResponseEntity<List<Facility>> response = facilityController.getAllFacilities();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockFacilities, response.getBody());
    }

    @Test
    void testAddFacility() {
        FacilityDto facilityDto = new FacilityDto(null, "Facility3", "Description3", 120.0, 2.0, "Category3", "photo3.jpg", true);
        Facility addedFacility = new Facility("Facility3", "Description3", 120.0, 2.0, "Category3", "photo3.jpg", true);
        when(facilityService.addFacility(facilityDto)).thenReturn(addedFacility);

        ResponseEntity<Facility> response = facilityController.addFacility(facilityDto);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(addedFacility, response.getBody());
    }
}
