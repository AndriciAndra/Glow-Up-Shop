package org.scrum.domain.controllers;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.scrum.domain.project.Client;
import org.scrum.domain.project.Facility;
import org.scrum.domain.project.Reservation;
import org.scrum.domain.services.servicesImpl.ReservationServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class ReservationControllerTest {

    @Mock
    private ReservationServiceImpl reservationService;

    @InjectMocks
    private ReservationController reservationController;

    private final MockMvc mockMvc;

    public ReservationControllerTest() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(reservationController).build();
    }

    @Test
    void testGetAllReservations() throws Exception {
        Reservation reservation1 = new Reservation("Confirmed", new Date(), new Date());
        Reservation reservation2 = new Reservation("Pending", new Date(), new Date());

        Mockito.when(reservationService.getAllReservations()).thenReturn(Arrays.asList(reservation1, reservation2));

        mockMvc.perform(get("/reservations/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    void testAddReservation() throws Exception {
        Reservation reservation = new Reservation("Confirmed", new Date(), new Date());
        Client client = new Client();
        Facility facility = new Facility();

        Mockito.when(reservationService.addReservation(Mockito.any(Reservation.class), Mockito.any(Client.class), Mockito.any(Facility.class)))
                .thenReturn(reservation);

        mockMvc.perform(post("/reservations/addReservation")
                        .content(asJsonString(reservation))
                        .content(asJsonString(client))
                        .content(asJsonString(facility))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.reservationId").value(reservation.getReservationId()));
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}