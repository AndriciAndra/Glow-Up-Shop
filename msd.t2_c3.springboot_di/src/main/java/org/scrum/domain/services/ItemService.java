package org.scrum.domain.services;

import org.scrum.domain.project.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems();

    Item addItem(Item item);
}
