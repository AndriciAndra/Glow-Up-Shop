package org.scrum.domain.project;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "reservation")
class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int reservationId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "facility_id", referencedColumnName = "id")
    private Facility facilityId;

    private String status;

    private Date startDate;
    private Date endDate;

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId=" + reservationId +
                ", facilityId=" + facilityId +
                ", status='" + status + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
