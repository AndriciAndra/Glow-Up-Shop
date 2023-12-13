package org.scrum.domain.services;

import org.scrum.domain.project.Facility;
import org.scrum.domain.project.dto.FacilityDto;

import java.util.List;

public interface FacilityService {
    List<Facility> getAll();

    Facility addFacility(FacilityDto facility);
}
