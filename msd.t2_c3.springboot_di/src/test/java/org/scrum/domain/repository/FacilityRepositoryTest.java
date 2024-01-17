package org.scrum.domain.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.scrum.domain.project.Facility;
import org.scrum.domain.repositories.FacilityRepository;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FacilityRepositoryTest {

    @Mock
    private FacilityRepository facilityRepository;


    @Test
    void testFindAll() {
        List<Facility> facilities = List.of(
                new Facility("Facility1", "Description1", 10.0, 1.5, "Category1", "Photo1", true),
                new Facility("Facility2", "Description2", 20.0, 2.5, "Category2", "Photo2", false)
        );

        when(facilityRepository.findAll()).thenReturn(facilities);

        List<Facility> result = facilityRepository.findAll();

        assertThat(result).hasSize(2);
        assertThat(result.get(0).getFacilityName()).isEqualTo("Facility1");
        assertThat(result.get(1).getFacilityName()).isEqualTo("Facility2");

        verify(facilityRepository, times(1)).findAll();
    }


}
