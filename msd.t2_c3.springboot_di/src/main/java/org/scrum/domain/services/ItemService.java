package org.scrum.domain.services;

import org.scrum.domain.project.Item;
import org.scrum.domain.project.dto.ItemDto;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems();

    Item addItem(ItemDto item);
}
