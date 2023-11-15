package org.scrum.domain.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.scrum.domain.project.Facility;
import org.scrum.domain.services.FacilityService;
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
public class TestJupiterProjectDomainFacilityControllerDefSDI {
    @Mock
    private FacilityService facilityService;

    @InjectMocks
    private FacilityController facilityController;

    private MockMvc mockMvc;

    @Test
    void getAllFacilities() throws Exception {
        List<Facility> facilities = Arrays.asList(
                new Facility("Example1", "This is an example1", 15.0, 3.0, "Example Category1", "example1.jpg", 30),
                new Facility("Example2", "This is an example2", 10.0, 2.0, "Example Category2", "example2.jpg", 20)
        );

        when(facilityService.getAllFacilities()).thenReturn(facilities);

        mockMvc = MockMvcBuilders.standaloneSetup(facilityController).build();

        mockMvc.perform(get("/facilities/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(facilities.size()));
    }

    @Test
    void addItem() throws Exception {
        Facility facility = new Facility("Example", "This is an example", 10.0, 2.0, "Example Category", "example.jpg", 20);
        when(facilityService.addFacility(any())).thenReturn(facility);

        mockMvc = MockMvcBuilders.standaloneSetup(facilityController).build();

        ObjectMapper objectMapper = new ObjectMapper();
        String newItemJson = objectMapper.writeValueAsString(facility);

        mockMvc.perform(post("/facilities/addFacility")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(newItemJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists());
    }
}