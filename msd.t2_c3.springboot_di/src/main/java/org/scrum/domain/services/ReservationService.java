package org.scrum.domain.services;

import org.scrum.domain.project.Reservation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    private List<Reservation> reservations = new ArrayList<>();
    private int reservationId = 1;

    public Reservation addReservation(Reservation reservation) {
        reservation.setReservationId(reservationId++);
        reservations.add(reservation);
        return reservation;
    }

    public List<Reservation> getAllReservations() {
        return reservations;
    }
}
