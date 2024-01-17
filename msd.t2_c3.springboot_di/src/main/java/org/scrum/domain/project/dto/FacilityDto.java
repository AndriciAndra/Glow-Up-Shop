package org.scrum.domain.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.scrum.domain.project.Facility;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacilityDto {
    private Integer id;
    private String facilityName;
    private String description;
    private Double costPrice;
    private double duration;
    private String category;
    private String photo;
    private boolean currentDisponibility;

    public FacilityDto(Facility facility) {
        id = facility.getId();
        facilityName = facility.getFacilityName();
        description = facility.getDescription();
        costPrice = facility.getCostPrice();
        duration = facility.getDuration();
        category = facility.getCategory();
        photo = facility.getPhoto();
        currentDisponibility = facility.isCurrentDisponibility();
    }
}
