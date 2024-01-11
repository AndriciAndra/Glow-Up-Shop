package org.scrum.domain.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.scrum.domain.controllers.OrderController;
import org.scrum.domain.project.Cart;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scrum.domain.project.Client;
import org.scrum.domain.project.Order;
import org.scrum.domain.services.ClientService;
import org.scrum.domain.services.OrderService;

import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    @Mock
    private OrderService orderService;

    @Mock
    private ClientService clientService;

    @InjectMocks
    private OrderController orderController;

    private final MockMvc mockMvc;

    public OrderControllerTest() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
    }

    @Test
    void testGetAllOrders() throws Exception {
    }

    @Test
    void testAddOrder() throws Exception {
        Client mockClient = new Client();
        Cart mockCart = new Cart();
        mockClient.setCart(mockCart);

        Mockito.when(clientService.findByUsername("testUser")).thenReturn(mockClient);
        Mockito.when(orderService.addOrder(mockCart)).thenReturn(new Order());

        mockMvc.perform(post("/orders/addOrder")
                        .param("username", "testUser")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void testAcceptOrder() throws Exception {
    }

    @Test
    void testCancelOrder() throws Exception {
    }
}
