package org.scrum.domain.project.dto;

import io.swagger.models.auth.In;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.scrum.domain.project.Facility;
import org.scrum.domain.project.Reservation;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
    private Integer reservationId;
    private Integer facilityId;
    private String status;
    private Date startDate;
    private Date endDate;

    public ReservationDto(Reservation reservation) {
        reservationId = reservation.getReservationId();
        facilityId = reservation.getFacility().getId();
        status = reservation.getStatus();
        startDate = reservation.getStartDate();
        endDate = reservation.getEndDate();
    }
}
