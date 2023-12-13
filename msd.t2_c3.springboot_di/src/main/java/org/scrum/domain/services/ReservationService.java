package org.scrum.domain.services;

import org.scrum.domain.project.Client;
import org.scrum.domain.project.Facility;
import org.scrum.domain.project.Reservation;

import java.util.List;

public interface ReservationService {
    Reservation addReservation(Reservation reservation, Client client, Facility facility);
    List<Reservation> getAllReservations();
}
