package org.scrum.domain.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.scrum.domain.project.Facility;
import org.scrum.domain.project.dto.FacilityDto;
import org.scrum.domain.repositories.FacilityRepository;
import org.scrum.domain.services.servicesImpl.FacilityServiceImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class FacilityServiceImplTest {

    @Mock
    private FacilityRepository facilityRepository;

    @InjectMocks
    private FacilityServiceImpl facilityService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAll() {
        List<Facility> mockFacilities = Arrays.asList(
                new Facility("Facility1", "Description1", 100.0, 1, "Category1", "photo1.jpg", true),
                new Facility("Facility2", "Description2", 150.0, 2, "Category2", "photo2.jpg", false)
        );
        when(facilityRepository.findAll()).thenReturn(mockFacilities);

        List<Facility> result = facilityService.getAll();

        assertEquals(2, result.size());
        assertEquals("Facility1", result.get(0).getFacilityName());
        assertEquals("Facility2", result.get(1).getFacilityName());

        verify(facilityRepository, times(1)).findAll();
    }

    @Test
    void testAddFacility() {
        FacilityDto facilityDto = new FacilityDto(null, "NewFacility", "NewDescription", 200.0, 3, "NewCategory", "newphoto.jpg", true);

        when(facilityRepository.save(any())).thenAnswer(invocation -> {
            Facility facility = invocation.getArgument(0);
            facility.setId(1);
            return facility;
        });

        Facility result = facilityService.addFacility(facilityDto);

        assertEquals(1, result.getId());
        assertEquals("NewFacility", result.getFacilityName());
        assertEquals("NewDescription", result.getDescription());

        verify(facilityRepository, times(1)).save(any());
    }
}
