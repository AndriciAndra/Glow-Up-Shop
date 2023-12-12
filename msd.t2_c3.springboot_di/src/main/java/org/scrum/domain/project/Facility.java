package org.scrum.domain.project;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table (name = "facility")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    private String facilityName;

    private String description;

    private Double costPrice;

    private double duration;

    private String category;

    private String photo;

    private boolean currentDisponibility;

    @Override
    public String toString() {
        return "Facility{" +
                "id=" + id +
                ", facilityName='" + facilityName + '\'' +
                ", description='" + description + '\'' +
                ", costPrice=" + costPrice +
                ", duration=" + duration +
                ", category='" + category + '\'' +
                ", photo='" + photo + '\'' +
                ", currentDisponibility=" + currentDisponibility +
                '}';
    }
}
