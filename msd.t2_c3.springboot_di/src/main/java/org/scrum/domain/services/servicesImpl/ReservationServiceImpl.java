package org.scrum.domain.services.servicesImpl;

import lombok.RequiredArgsConstructor;
import org.scrum.domain.project.Client;
import org.scrum.domain.project.ClientHasReservation;
import org.scrum.domain.project.Facility;
import org.scrum.domain.project.Reservation;
import org.scrum.domain.project.dto.FacilityDto;
import org.scrum.domain.project.dto.ReservationDto;
import org.scrum.domain.repositories.ClientHasReservationRepository;
import org.scrum.domain.repositories.ClientRepository;
import org.scrum.domain.repositories.FacilityRepository;
import org.scrum.domain.repositories.ReservationRepository;
import org.scrum.domain.services.ReservationService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final FacilityRepository facilityRepository;
    private final ClientRepository clientRepository;
    private final ClientHasReservationRepository clientHasReservationRepository;

    @Override
    public Reservation addReservation(Reservation reservation, int clientId, int facilityId) {
        Reservation newReservation = new Reservation(reservation.getStartDate(), reservation.getEndDate());
        Optional<Facility> facility = facilityRepository.findById(facilityId);
        if (facility.isPresent()) {
            newReservation.setStatus("Waiting for approval");
            newReservation.setFacility(facility.get());
            //reservationRepository.save(reservation);
        }

        ClientHasReservation clientHasReservation = new ClientHasReservation();
        Optional<Client> client = clientRepository.findById(clientId);
        if (client.isPresent()) {
            clientHasReservation.setClient(client.get());
            clientHasReservation.setReservation(newReservation);
            clientHasReservationRepository.save(clientHasReservation);
        }

        return newReservation;
    }

    @Override
    public List<ReservationDto> getAllReservations() {
        return transferData(reservationRepository.findAll());
    }

    private List<ReservationDto> transferData(List<Reservation> reservations) {
        List<ReservationDto> reservationDtos = new ArrayList<>();
        for (Reservation reservation : reservations) {
            ReservationDto reservationDto = new ReservationDto(reservation);
            reservationDtos.add(reservationDto);
        }
        return reservationDtos;
    }
}
