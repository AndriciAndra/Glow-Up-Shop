package org.scrum.domain.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.scrum.domain.controllers.CartController;
import org.scrum.domain.repositories.CartRepository; // Ensure correct import
import org.scrum.domain.project.Cart;
import org.scrum.domain.project.Client;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CartRepositoryTest {

    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private CartController cartController;

    @Test
    void testFindByClientUsername() {
        // Arrange
        Client client = new Client();
        client.setUsername("testUser");

        Cart cart = new Cart();
        cart.setId(1);
        cart.setClient(client);

        when(cartRepository.findByClient_Username("testUser")).thenReturn(Optional.of(cart));

        Optional<Cart> result = cartRepository.findByClient_Username("testUser");

        assertThat(result).isPresent();
        assertThat(result.get().getId()).isEqualTo(1);
        assertThat(result.get().getClient().getUsername()).isEqualTo("testUser");

        verify(cartRepository, times(1)).findByClient_Username("testUser");
    }
}
