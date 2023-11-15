package org.scrum.domain.controllers;

import org.scrum.domain.project.Order;
import org.scrum.domain.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping(value = "/addOrder", consumes = "application/json")
    public Order addOrder(@RequestBody Order storeItem) {
        return orderService.addOrder(storeItem);
    }
}
