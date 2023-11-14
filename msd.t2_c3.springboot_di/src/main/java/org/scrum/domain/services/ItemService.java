package org.scrum.domain.services;

import org.scrum.domain.project.Item;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {

    private List<Item> items = new ArrayList<>();
    private int id = 1;

    public Item addItem(Item item) {
        item.setId(id++);
        items.add(item);
        return item;
    }

    public List<Item> getAllItems() {
        return items;
    }
}