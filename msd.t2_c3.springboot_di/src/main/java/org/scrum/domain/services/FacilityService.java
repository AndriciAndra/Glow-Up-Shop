package org.scrum.domain.services;

import org.scrum.domain.project.Facility;
import java.util.ArrayList;
import java.util.List;

public class FacilityService {
    private List<Facility> facilities = new ArrayList<>();
    private int id = 1;

    public Facility addFacility(@org.jetbrains.annotations.NotNull Facility facility) {
        facility.setId(id++);
        facilities.add(facility);
        return facility;
    }
    public List<Facility> getAllFacilities() {
        return facilities;
    }
}
