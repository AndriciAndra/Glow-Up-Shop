package org.scrum.domain.controllers;

import org.scrum.domain.project.Cart;
import org.scrum.domain.project.Client;
import org.scrum.domain.project.dto.OrderDto;
import org.scrum.domain.services.ClientService;
import org.scrum.domain.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}")
    public List<OrderDto> getAllOrders(@PathVariable int id) {
        return orderService.getOrdersByClient(id);
    }

    @PostMapping("/addOrder")
    public ResponseEntity<Object> addOrder(@Param("username") String username) {
        Client client = clientService.findByUsername(username);
        Cart cart = client.getCart();
        return orderService.addOrder(cart);
    }

    @PutMapping("/acceptOrder/{id}")
    public ResponseEntity<Object> acceptOrder(@PathVariable int id) {
        return orderService.acceptOrder(id);
    }

    @DeleteMapping("/deleteOrder/{id}")
    public ResponseEntity<Object> cancelOrder(@PathVariable int id) {
        return orderService.cancelOrder(id);
    }
}
