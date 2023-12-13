package org.scrum.domain.controllers;

import org.scrum.domain.project.Item;
import org.scrum.domain.project.dto.ItemDto;
import org.scrum.domain.services.servicesImpl.ItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemServiceImpl itemServiceImpl;

    @GetMapping("/")
    public List<Item> getAllItems() {
        return itemServiceImpl.getAllItems();
    }
    @PostMapping(value = "/addItem", consumes = "application/json")
    public Item addItem(@RequestBody ItemDto item) {
        return itemServiceImpl.addItem(item);
    }
}
