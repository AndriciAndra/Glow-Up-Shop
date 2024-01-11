package org.scrum.domain.controllers;

import org.scrum.domain.project.Client;
import org.scrum.domain.project.dto.CartDto;
import org.scrum.domain.project.dto.ItemDto;
import org.scrum.domain.services.CartService;
import org.scrum.domain.services.ClientService;
import org.scrum.domain.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {
    @Autowired
    private CartService cartService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private ClientService clientService;

    @PostMapping("/addItemCart")
    public ResponseEntity<Object> addItemToCart(@RequestParam("id") int id,
                                                @RequestParam(value = "quantity", required = false, defaultValue = "1") int quantity,
                                                @RequestParam("client") String username) {
        ItemDto itemDto = itemService.getById(id);
        return cartService.addItemToCart(itemDto, quantity, username);
    }

    @GetMapping("/getCartByUsername")
    public CartDto getCartByUsername(@RequestParam("username") String username) {
        Client client = clientService.findByUsername(username);
        return cartService.convertCartToCartDto(client.getCart());
    }

    @DeleteMapping("/removeItem")
    public ResponseEntity<Object> removeItemFromCart(@RequestParam("itemId") int itemId, @RequestParam("client") String username) {
        return cartService.removeItemFromCart(itemId, username);
    }
}
