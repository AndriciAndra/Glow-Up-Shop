package org.scrum.domain.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import org.scrum.domain.project.dto.CartDto;
import org.scrum.domain.project.dto.ItemDto;
import org.scrum.domain.services.CartService;
import org.scrum.domain.services.ClientService;
import org.scrum.domain.services.ItemService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.scrum.domain.project.Client;

class Services {
    @Mock
    private CartService cartService;
    @Mock
    private ItemService itemService;
    @Mock
    private ClientService clientService;
    @InjectMocks
    private CartController cartController;

    @Test
    void testAddItemToCart() {
        ItemDto mockItemDto = new ItemDto();
        Mockito.when(itemService.getById(Mockito.anyInt())).thenReturn(mockItemDto);

        ResponseEntity<Object> response = cartController.addItemToCart(1, 2, "testUser");
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    void testGetCartByUsername() {
        Client mockClient = new Client();
        Mockito.when(clientService.findByUsername(Mockito.anyString())).thenReturn(mockClient);

        CartDto mockCartDto = new CartDto();
        Mockito.when(cartService.convertCartToCartDto(Mockito.any())).thenReturn(mockCartDto);

        CartDto result = cartController.getCartByUsername("testUser");
    }
    @Test
    void testRemoveItemFromCart() {
        ResponseEntity<Object> mockResponseEntity = ResponseEntity.ok().build();
        Mockito.when(cartService.removeItemFromCart(Mockito.anyInt(), Mockito.anyString())).thenReturn(mockResponseEntity);

        ResponseEntity<Object> response = cartController.removeItemFromCart(1, "testUser");
        assertEquals(200, response.getStatusCodeValue());
    }
}
