package org.scrum.domain.controllers;

import org.scrum.domain.project.Client;
import org.scrum.domain.project.Facility;
import org.scrum.domain.project.Reservation;
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
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @PostMapping(value = "/addReservation", consumes = "application/json")
    public Reservation addReservation(@RequestBody Reservation reservation, @RequestBody Client client, @RequestBody Facility facility) {
        return reservationService.addReservation(reservation, client, facility);
    }
}
