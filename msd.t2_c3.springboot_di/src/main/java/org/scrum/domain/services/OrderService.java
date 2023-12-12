package org.scrum.domain.services;

import org.scrum.domain.project.Cart;
import org.scrum.domain.project.Order;

import java.util.List;

public interface OrderService {
    Order addOrder(Cart cart);
    List<Order> getAllOrders();
}
