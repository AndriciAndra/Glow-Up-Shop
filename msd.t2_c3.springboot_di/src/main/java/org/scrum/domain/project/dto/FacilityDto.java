package org.scrum.domain.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
