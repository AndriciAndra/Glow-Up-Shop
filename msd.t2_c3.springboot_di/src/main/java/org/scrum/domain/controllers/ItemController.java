package org.scrum.domain.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.scrum.domain.project.Item;
import org.scrum.domain.project.dto.ItemDto;
import org.scrum.domain.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public List<ItemDto> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public ItemDto getItemById(@PathVariable int id) {
        return itemService.getById(id);
    }

    @GetMapping("/byCategory/{category}")
    public List<Item> getItemsByCategory(@PathVariable String category) {
        return itemService.findAllByCategory(category);
    }

    @PostMapping("/addItem")
    public Item addItem(@RequestParam("item") String itemJson,
                        @RequestParam("image") MultipartFile imageItem) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ItemDto itemDto = objectMapper.readValue(itemJson, ItemDto.class);
            return itemService.addItem(imageItem, itemDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PutMapping("/disableItem/{id}")
    public void disableItemById(@PathVariable int id) {
        itemService.disableById(id);
    }

    @PutMapping("/enableItem/{id}")
    public void enableItemById(@PathVariable int id) {
        itemService.enableById(id);
    }

    @PutMapping("/updateItem/{id}")
    public Item updateItem(@PathVariable int id,
                           @RequestParam("item") String itemJson,
                           @RequestParam("image") MultipartFile imageItem) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ItemDto itemDto = objectMapper.readValue(itemJson, ItemDto.class);
            return itemService.update(id, imageItem, itemDto);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @DeleteMapping("/deleteItem/{id}")
    public void deleteItem(@PathVariable int id) {
        itemService.deleteItem(id);
    }
}
