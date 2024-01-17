package org.scrum.domain.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.scrum.domain.project.Client;
import org.scrum.domain.project.Facility;
import org.scrum.domain.project.Reservation;
import org.scrum.domain.project.dto.ItemDto;
import org.scrum.domain.project.dto.ReservationDto;
import org.scrum.domain.services.servicesImpl.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationServiceImpl reservationService;

    @GetMapping("/")
    public List<ReservationDto> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @PostMapping("/makeReservation")
    public Reservation addReservation(@RequestParam("reservation") String reservationJson, @RequestParam("clientId") int clientId, @RequestParam("facilityId") int facilityId) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Reservation reservation = objectMapper.readValue(reservationJson, Reservation.class);
            return reservationService.addReservation(reservation, clientId, facilityId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
