package org.scrum.domain.services;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.scrum.domain.project.Cart;
import org.scrum.domain.project.CartItem;
import org.scrum.domain.project.Order;
import org.scrum.domain.repositories.OrderDetailRepository;
import org.scrum.domain.repositories.OrderRepository;
import org.scrum.domain.services.CartService;
import org.scrum.domain.services.servicesImpl.OrderServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class OrderServiceImplTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderDetailRepository orderDetailRepository;

    @Mock
    private CartService cartService;

    @InjectMocks
    private OrderServiceImpl orderService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddOrder() {
    }

    @Test
    void testGetAllOrders() {

    }

    @Test
    void testAcceptOrder() {

    }

    @Test
    void testCancelOrder() {

    }
}