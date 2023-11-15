package org.scrum.domain.services;

import org.scrum.domain.project.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private List<Order> orders = new ArrayList<>();
    private int orderId = 1;

    public Order addOrder(Order order) {
        order.setOrderId(orderId++);
        orders.add(order);
        return order;
    }

    public List<Order> getAllOrders() {
        return orders;
    }
}
