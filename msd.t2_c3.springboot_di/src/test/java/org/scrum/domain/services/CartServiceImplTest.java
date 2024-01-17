package org.scrum.domain.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.scrum.domain.project.Cart;
import org.scrum.domain.project.Client;
import org.scrum.domain.project.dto.CartDto;
import org.scrum.domain.project.dto.CartItemDto;
import org.scrum.domain.project.dto.ItemDto;
import org.scrum.domain.repositories.CartItemRepository;
import org.scrum.domain.repositories.CartRepository;
import org.scrum.domain.services.servicesImpl.CartServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CartServiceImplTest {

    @Mock
    private CartRepository cartRepository;

    @Mock
    private CartItemRepository cartItemRepository;

    @Mock
    private ClientService clientService;

    @InjectMocks
    private CartServiceImpl cartService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddItemToCart() {
        Client mockClient = new Client();
        mockClient.setUsername("testUser");
        when(clientService.findByUsername("testUser")).thenReturn(mockClient);

        Cart mockCart = new Cart();
        when(cartRepository.save(any())).thenReturn(mockCart);

        ItemDto itemDto = new ItemDto();
        itemDto.setId(1);
        itemDto.setProductName("Test Product");
        itemDto.setCostPrice(100.0);
        itemDto.setSalePrice(90.0);

        ResponseEntity<Object> result = cartService.addItemToCart(itemDto, 2, "testUser");

        assertEquals("Item added to cart successfully!", result.getBody());
        assertEquals(HttpStatus.OK, result.getStatusCode());

        verify(clientService, times(1)).findByUsername("testUser");
        verify(cartRepository, times(1)).save(any());
        verify(cartItemRepository, times(1)).save(any());
    }
}
