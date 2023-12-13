package org.scrum.domain.services.servicesImpl;

import lombok.RequiredArgsConstructor;
import org.scrum.domain.project.Facility;
import org.scrum.domain.project.dto.FacilityDto;
import org.scrum.domain.repositories.FacilityRepository;
import org.scrum.domain.services.FacilityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacilityServiceImpl implements FacilityService {
    private final FacilityRepository facilityRepository;

    @Override
    public List<Facility> getAll() {
        return facilityRepository.findAll();
    }

    @Override
    public Facility addFacility(FacilityDto facility) {
        Facility newFacility = new Facility(facility.getFacilityName(), facility.getDescription(), facility.getCostPrice(), facility.getDuration(), facility.getCategory(), facility.getPhoto(), facility.isCurrentDisponibility());
        return facilityRepository.save(newFacility);
    }
}
