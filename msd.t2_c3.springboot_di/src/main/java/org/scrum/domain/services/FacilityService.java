package org.scrum.domain.services;

import org.scrum.domain.project.Facility;
import org.scrum.domain.project.dto.FacilityDto;
import org.scrum.domain.project.dto.ItemDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FacilityService {
    List<FacilityDto> getAll();

    Facility addFacility(MultipartFile imageItem, FacilityDto facilityDto);
}
