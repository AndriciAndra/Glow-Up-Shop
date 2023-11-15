package org.scrum.domain.controllers;

import org.scrum.domain.project.Store;
import org.scrum.domain.services.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping("/")
    public List<Store> getAllStoreItems() {
        return storeService.getAllStoreItems();
    }

    @PostMapping(value = "/sellProduct", consumes = "application/json")
    public Store sellProduct(@RequestBody Store storeItem) {
        return storeService.sellProduct(storeItem);
    }
}
