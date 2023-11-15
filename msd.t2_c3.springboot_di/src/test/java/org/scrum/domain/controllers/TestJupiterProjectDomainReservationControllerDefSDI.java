package org.scrum.domain.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.scrum.domain.project.Reservation;
import org.scrum.domain.services.ReservationService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//JUnit.5
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TestJupiterProjectDomainReservationControllerDefSDI {
    @Mock
    private ReservationService reservationService;

    @InjectMocks
    private ReservationController reservationController;

    private MockMvc mockMvc;

    @Test
    void getAllFacilities() throws Exception {
        List<Reservation> reservations = Arrays.asList(
                new Reservation("Ana", "coafor", "21.11.2023"),
                new Reservation("Marina", "tratament", "23.11.2023")
        );

        when(reservationService.getAllReservations()).thenReturn(reservations);

        mockMvc = MockMvcBuilders.standaloneSetup(reservationController).build();

        mockMvc.perform(get("/reservations/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(reservations.size()));
    }

    @Test
    void addItem() throws Exception {
        Reservation reservation = new Reservation("Ana", "coafor", "12.11.2023");
        when(reservationService.addReservation(any())).thenReturn(reservation);

        mockMvc = MockMvcBuilders.standaloneSetup(reservationController).build();

        ObjectMapper objectMapper = new ObjectMapper();
        String newItemJson = objectMapper.writeValueAsString(reservation);

        mockMvc.perform(post("/reservations/addReservation")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newItemJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists());
    }
}