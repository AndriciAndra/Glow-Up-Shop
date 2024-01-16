package org.scrum.domain.services;

import org.scrum.domain.project.Cart;
import org.scrum.domain.project.dto.OrderDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OrderService {
    ResponseEntity<Object> addOrder(Cart cart);

    List<OrderDto> getOrdersByClient(int id);

    ResponseEntity<Object> acceptOrder(int id);

    ResponseEntity<Object> cancelOrder(int id);
}
