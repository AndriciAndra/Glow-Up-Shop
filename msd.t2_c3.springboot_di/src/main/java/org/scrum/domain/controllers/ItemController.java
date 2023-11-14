package org.scrum.domain.controllers;

import org.scrum.domain.project.Item;
import org.scrum.domain.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }
    @PostMapping(value = "/addItem", consumes = "application/json")
    public Item addItem(@RequestBody Item item) {
        return itemService.addItem(item);
    }
}
