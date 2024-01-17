package org.scrum.domain.services;

import org.scrum.domain.project.Client;
import org.scrum.domain.project.Facility;
import org.scrum.domain.project.Reservation;
import org.scrum.domain.project.dto.ReservationDto;

import java.util.List;

public interface ReservationService {
    Reservation addReservation(Reservation reservation, int clientId, int facilityId);
    List<ReservationDto> getAllReservations();
}
