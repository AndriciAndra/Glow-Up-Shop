package org.scrum.domain.services;

import org.scrum.domain.project.Cart;
import org.scrum.domain.project.dto.CartDto;
import org.scrum.domain.project.dto.ItemDto;
import org.springframework.http.ResponseEntity;

public interface CartService {
    ResponseEntity<Object> addItemToCart(ItemDto itemDto, int quantity, String username);

    ResponseEntity<Object> updateCart(ItemDto itemDto, int quantity, String username);

    ResponseEntity<Object> removeItemFromCart(int itemId, String username);

    void deleteCartById(int id);

    Cart getCart(String username);

    CartDto convertCartToCartDto(Cart cart);
}
