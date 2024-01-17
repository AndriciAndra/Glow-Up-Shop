package org.scrum.domain.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.scrum.domain.project.Client;
import org.scrum.domain.services.ClientService;
import org.scrum.domain.services.OrderService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @Mock
    private ClientService clientService;

    @InjectMocks
    private OrderController orderController;

    @Test
    void getAllOrders() throws Exception {
        when(orderService.getOrdersByClient(1)).thenReturn(Collections.emptyList());

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();

        mockMvc.perform(MockMvcRequestBuilders.get("/orders/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("[]"));
    }

    @Test
    void addOrder() throws Exception {
        // Mocking the service response
        when(clientService.findByUsername("testUser")).thenReturn(new Client());
        when(orderService.addOrder(any())).thenReturn(ResponseEntity.ok().build());

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();

        mockMvc.perform(MockMvcRequestBuilders.post("/orders/addOrder")
                        .param("username", "testUser"))
                .andDo(print())  // Print request and response details for debugging
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void acceptOrder() throws Exception {
        // Mocking the service response
        when(orderService.acceptOrder(1)).thenReturn(ResponseEntity.ok().build());

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();

        mockMvc.perform(MockMvcRequestBuilders.put("/orders/acceptOrder/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void cancelOrder() throws Exception {
        // Mocking the service response
        when(orderService.cancelOrder(1)).thenReturn(ResponseEntity.ok().build());

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();

        mockMvc.perform(MockMvcRequestBuilders.delete("/orders/deleteOrder/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
