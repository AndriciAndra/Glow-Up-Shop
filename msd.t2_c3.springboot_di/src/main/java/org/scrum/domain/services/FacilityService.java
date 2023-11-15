package org.scrum.domain.services;

import org.scrum.domain.project.Facility;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacilityService {
    private List<Facility> facilities = new ArrayList<>();
    private int id = 1;

    public Facility addFacility(Facility facility) {
        facility.setId(id++);
        facilities.add(facility);
        return facility;
    }
    public List<Facility> getAllFacilities() {
        return facilities;
    }
}
