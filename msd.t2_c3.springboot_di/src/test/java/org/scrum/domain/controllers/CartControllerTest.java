package org.scrum.domain.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.scrum.domain.project.Client;
import org.scrum.domain.project.dto.CartDto;
import org.scrum.domain.project.dto.ItemDto;
import org.scrum.domain.services.CartService;
import org.scrum.domain.services.ClientService;
import org.scrum.domain.services.ItemService;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CartControllerTest {

    @InjectMocks
    private CartController cartController;

    @Mock
    private CartService cartService;

    @Mock
    private ItemService itemService;

    @Mock
    private ClientService clientService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddItemToCart() {
    }
    @Test
    void testGetCartByUsername() {
    }
    @Test
    void testRemoveItemFromCart() {
    }
}
