package org.scrum.domain.services;

import org.scrum.domain.project.Cart;
import org.scrum.domain.project.Order;
import org.springframework.http.ResponseEntity;

public interface OrderService {
    Order addOrder(Cart cart);

    ResponseEntity<Object> getAllOrders();

    ResponseEntity<Object> acceptOrder(int id);

    ResponseEntity<Object> cancelOrder(int id);
}
