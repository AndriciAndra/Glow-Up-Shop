package org.scrum.domain.services.servicesImpl;

import lombok.RequiredArgsConstructor;
import org.scrum.domain.project.Item;
import org.scrum.domain.project.utils.ImageUpload;
import org.scrum.domain.project.dto.ItemDto;
import org.scrum.domain.repositories.ItemRepository;
import org.scrum.domain.services.ItemService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ImageUpload imageUpload;

    @Override
    public List<ItemDto> getAllItems() {
        List<ItemDto> itemDtoList = transferData(itemRepository.getAllItem());
        if (itemDtoList.isEmpty())
            return null;
        return itemDtoList;
    }

    @Override
    public Item addItem(MultipartFile imageItem, ItemDto item) {
        Item newItem = new Item(item.getProductName(), item.getDescription(), item.getCostPrice(), item.getSalePrice(), item.getCategory(), item.getPhoto(), item.getCurrentQuantity(), true, false);
        try {
            if (imageItem == null) {
                newItem.setPhoto(null);
            } else {
                imageUpload.uploadImage(imageItem);
                newItem.setPhoto(Base64.getEncoder().encodeToString(imageItem.getBytes()));
            }
            return itemRepository.save(newItem);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Item update(int id, MultipartFile imageItem, ItemDto itemDto) {
        try {
            Item itemUpdate = itemRepository.getReferenceById(id);
            if (imageItem.getBytes().length > 0) {
                if (imageUpload.checkExisted(imageItem)) {
                    itemUpdate.setPhoto(itemUpdate.getPhoto());
                } else {
                    imageUpload.uploadImage(imageItem);
                    itemUpdate.setPhoto(Base64.getEncoder().encodeToString(imageItem.getBytes()));
                }
            }
            itemUpdate.copyItem(itemDto);
            return itemRepository.save(itemUpdate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void enableById(int id) {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()) {
            item.get().setActivated(true);
            item.get().setDeleted(false);
            itemRepository.save(item.get());
        }
    }

    @Override
    public void disableById(int id) {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()) {
            item.get().setDeleted(true);
            item.get().setActivated(false);
            itemRepository.save(item.get());
        }
    }

    @Override
    public ItemDto getById(int id) {
        Optional<Item> item = itemRepository.findById(id);
        return item.map(ItemDto::new).orElse(null);
    }

    @Override
    public List<Item> findAllByCategory(String category) {
        List<Item> itemList = itemRepository.findAllByCategory(category);
        if (itemList.isEmpty())
            return null;
        return itemList;
    }

    @Override
    public void deleteItem(int id) {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent())
            itemRepository.deleteById(id);
    }

    private List<ItemDto> transferData(List<Item> items) {
        List<ItemDto> itemDtos = new ArrayList<>();
        for (Item item : items) {
            ItemDto itemDto = new ItemDto(item);
            itemDtos.add(itemDto);
        }
        return itemDtos;
    }
}

