package org.scrum.domain.services.servicesImpl;

import lombok.RequiredArgsConstructor;
import org.scrum.domain.project.Item;
import org.scrum.domain.repositories.ItemRepository;
import org.scrum.domain.services.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item addItem(Item item) {
        Item newItem = new Item(item.getProductName(), item.getDescription(), item.getCostPrice(), item.getSalePrice(), item.getCategory(), item.getPhoto(), item.getCurrentQuantity(), false, true);
        return itemRepository.save(newItem);
    }
}

