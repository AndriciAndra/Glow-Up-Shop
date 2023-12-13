package org.scrum.domain.services;

import org.scrum.domain.project.Facility;

import java.util.List;

public interface FacilityService {
    List<Facility> getAll();

    Facility addFacility(Facility facility);
}
