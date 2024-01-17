package org.scrum.domain.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.scrum.domain.project.Client;
import org.scrum.domain.project.Facility;
import org.scrum.domain.project.Reservation;
import org.scrum.domain.services.servicesImpl.ReservationServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ReservationControllerTest {

    @InjectMocks
    private ReservationController reservationController;

    @Mock
    private ReservationServiceImpl reservationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllReservations() {
        List<Reservation> mockReservations = Arrays.asList(
                new Reservation("Pending", new Date(), new Date()),
                new Reservation("Approved", new Date(), new Date())
        );
        when(reservationService.getAllReservations()).thenReturn(mockReservations);

        List<Reservation> response = reservationController.getAllReservations();

        assertEquals(mockReservations, response);
    }

    @Test
    void testAddReservation() {
        Reservation mockReservation = new Reservation("Pending", new Date(), new Date());
        Client mockClient = new Client();
        Facility mockFacility = new Facility();

        when(reservationService.addReservation(any(Reservation.class), any(Client.class), any(Facility.class))).thenReturn(mockReservation);

        Reservation response = reservationController.addReservation(mockReservation, mockClient, mockFacility);

        assertEquals(mockReservation, response);
    }
}
