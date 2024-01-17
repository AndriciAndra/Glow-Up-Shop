package org.scrum.domain.repository;

import org.scrum.domain.repositories.CartItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.scrum.domain.controllers.CartController;
import org.scrum.domain.project.CartItem;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CartItemRepositoryTest {

    @Mock
    private CartItemRepository cartItemRepository;

    @InjectMocks
    private CartController cartController;

    @Test
    void testFindById() {
        // Arrange
        CartItem cartItem = new CartItem();
        cartItem.setId(1);

        when(cartItemRepository.findById(1)).thenReturn(Optional.of(cartItem));

        // Act
        Optional<CartItem> result = cartItemRepository.findById(1);

        // Assert
        assertThat(result).isPresent();
        assertThat(result.get().getId()).isEqualTo(1);

        // Verify
        verify(cartItemRepository, times(1)).findById(1);
    }

}