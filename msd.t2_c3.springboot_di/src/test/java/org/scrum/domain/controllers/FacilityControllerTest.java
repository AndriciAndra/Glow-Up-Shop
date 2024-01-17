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
        List<FacilityDto> mockFacilities = Arrays.asList(
                new FacilityDto(new Facility("Facility1", "Description1", 100.0, 2.5, "Category1", "photo1.jpg", true)),
                new FacilityDto(new Facility("Facility2", "Description2", 150.0, 3.0, "Category2", "photo2.jpg", false))
        );
        when(facilityService.getAll()).thenReturn(mockFacilities);

        List<FacilityDto> response = facilityController.getAllFacilities();

        assertEquals(2, response.size());
        assertEquals(mockFacilities.get(0), response.get(0));
    }
}
