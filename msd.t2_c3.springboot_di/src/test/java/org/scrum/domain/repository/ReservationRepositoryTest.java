package org.scrum.domain.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.scrum.domain.project.Client;  // Import the correct Client class
import org.scrum.domain.project.Facility;  // Import the correct Facility class
import org.scrum.domain.project.Reservation;
import org.scrum.domain.repositories.ReservationRepository;
import org.scrum.domain.services.servicesImpl.ReservationServiceImpl;  // Import the correct ReservationServiceImpl class

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReservationRepositoryTest {

    @InjectMocks
    private ReservationServiceImpl reservationService;

    @Mock
    private ReservationRepository reservationRepositoryMock;

    @Test
    void testGetAllReservationsWhenEmpty() {
        when(reservationRepositoryMock.findAll()).thenReturn(new ArrayList<>());

        List<Reservation> result = reservationService.getAllReservations();

        assertEquals(0, result.size());
    }

    @Test
    void testGetAllReservationsWhenNotEmpty() {
        List<Reservation> mockReservationList = new ArrayList<>();
        Reservation reservation1 = new Reservation("Confirmed", new Date(), new Date());
        reservation1.setReservationId(1);
        mockReservationList.add(reservation1);

        when(reservationRepositoryMock.findAll()).thenReturn(mockReservationList);

        List<Reservation> result = reservationService.getAllReservations();

        assertEquals(1, result.size());
        assertEquals(1, result.get(0).getReservationId());
    }

}