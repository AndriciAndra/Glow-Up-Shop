package org.scrum.domain.services;

import org.scrum.domain.project.Item;
import org.scrum.domain.project.dto.ItemDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ItemService {
    List<ItemDto> getAllItems();

    Item addItem(MultipartFile imageItem, ItemDto item);

    Item update(int id, MultipartFile imageItem, ItemDto itemDto);

    void enableById(int id);

    void disableById(int id);

    ItemDto getById(int id);

    List<Item> findAllByCategory(String category);

    void deleteItem(int id);

}
