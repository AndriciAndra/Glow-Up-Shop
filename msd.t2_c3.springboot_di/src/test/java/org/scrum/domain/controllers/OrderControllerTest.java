package org.scrum.domain.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.scrum.domain.project.Cart;
import org.scrum.domain.project.Client;
import org.scrum.domain.project.Order;
import org.scrum.domain.services.ClientService;
import org.scrum.domain.services.OrderService;
import org.springframework.http.ResponseEntity;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OrderControllerTest {

    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderService orderService;

    @Mock
    private ClientService clientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllOrders() {
        when(orderService.getAllOrders()).thenReturn(ResponseEntity.ok("Mocked Order List"));

        ResponseEntity<Object> response = orderController.getAllOrders();

        assertEquals(ResponseEntity.ok("Mocked Order List"), response);
    }

    @Test
    void testAcceptOrder() {
        int orderId = 1;
        when(orderService.acceptOrder(orderId)).thenReturn(ResponseEntity.ok("Order accepted successfully"));

        ResponseEntity<Object> response = orderController.acceptOrder(orderId);

        assertEquals(ResponseEntity.ok("Order accepted successfully"), response);
    }

    @Test
    void testCancelOrder() {
        int orderId = 1;
        when(orderService.cancelOrder(orderId)).thenReturn(ResponseEntity.ok("Order canceled successfully"));

        ResponseEntity<Object> response = orderController.cancelOrder(orderId);

        assertEquals(ResponseEntity.ok("Order canceled successfully"), response);
    }
}
