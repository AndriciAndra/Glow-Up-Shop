package org.scrum.domain.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.scrum.domain.project.Facility;
import org.scrum.domain.project.dto.FacilityDto;
import org.scrum.domain.services.servicesImpl.FacilityServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;

class FacilityControllerTest {

    @Mock
    private FacilityServiceImpl facilityService;

    @InjectMocks
    private FacilityController facilityController;

    @Test
    void testGetAllFacilities() {
        Facility facility1 = new Facility("Facility1", "Description1", 100.0, 2.5, "Category1", "photo1.jpg", true);
        Facility facility2 = new Facility("Facility2", "Description2", 150.0, 3.0, "Category2", "photo2.jpg", false);

        Mockito.when(facilityService.getAll()).thenReturn(Arrays.asList(facility1, facility2));

        ResponseEntity<List<Facility>> responseEntity = facilityController.getAllFacilities();
        List<Facility> result = responseEntity.getBody();

        assertEquals(2, result.size());
        assertEquals("Facility1", result.get(0).getFacilityName());
        assertEquals("Facility2", result.get(1).getFacilityName());
    }

    @Test
    void testAddFacility() {
        FacilityDto facilityDto = new FacilityDto(null, "New Facility", "New Description", 200.0, 4.0, "New Category", "new_photo.jpg", true);
        Facility newFacility = new Facility(
                facilityDto.getFacilityName(),
                facilityDto.getDescription(),
                facilityDto.getCostPrice(),
                facilityDto.getDuration(),
                facilityDto.getCategory(),
                facilityDto.getPhoto(),
                facilityDto.isCurrentDisponibility()
        );

        Mockito.when(facilityService.addFacility(any())).thenReturn(newFacility);

        ResponseEntity<Facility> responseEntity = facilityController.addFacility(facilityDto);
        Facility result = responseEntity.getBody();

        assertEquals(facilityDto.getFacilityName(), result.getFacilityName());
        assertEquals(facilityDto.getDescription(), result.getDescription());
        assertEquals(facilityDto.getCostPrice(), result.getCostPrice());
        assertEquals(facilityDto.getDuration(), result.getDuration());
        assertEquals(facilityDto.getCategory(), result.getCategory());
        assertEquals(facilityDto.getPhoto(), result.getPhoto());
        assertEquals(facilityDto.isCurrentDisponibility(), result.isCurrentDisponibility());
    }
}
