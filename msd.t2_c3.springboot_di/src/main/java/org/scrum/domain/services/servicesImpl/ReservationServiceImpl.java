package org.scrum.domain.services.servicesImpl;

import lombok.RequiredArgsConstructor;
import org.scrum.domain.project.Client;
import org.scrum.domain.project.ClientHasReservation;
import org.scrum.domain.project.Facility;
import org.scrum.domain.project.Reservation;
import org.scrum.domain.repositories.ClientHasReservationRepository;
import org.scrum.domain.repositories.ReservationRepository;
import org.scrum.domain.services.ReservationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final ClientHasReservationRepository clientHasReservationRepository;

    @Override
    public Reservation addReservation(Reservation reservation, Client client, Facility facility) {
        Reservation newReservation = new Reservation(reservation.getStatus(), reservation.getStartDate(), reservation.getEndDate());
        newReservation.setFacility(facility);
        reservationRepository.save(reservation);

        ClientHasReservation clientHasReservation = new ClientHasReservation();
        clientHasReservation.setClient(client);
        clientHasReservation.setReservation(newReservation);

        clientHasReservationRepository.save(clientHasReservation);

        return newReservation;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
}
