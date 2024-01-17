package org.scrum.domain.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.scrum.domain.project.Item;
import org.scrum.domain.project.dto.ItemDto;
import org.scrum.domain.services.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class ItemControllerTest {

    @InjectMocks
    private ItemController itemController;

    @Mock
    private ItemService itemService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllItems() {
        List<ItemDto> mockItems = Arrays.asList(
                new ItemDto(1, "Product1", "Description1", 100.0, 90.0, "Category1", "photo1.jpg", 10, true, false),
                new ItemDto(2, "Product2", "Description2", 150.0, 120.0, "Category2", "photo2.jpg", 15, true, false)
        );
        when(itemService.getAllItems()).thenReturn(mockItems);
        List<ItemDto> response = itemController.getAllItems();
        assertEquals(mockItems, response);
    }

    @Test
    void testGetItemById() {
        int itemId = 1;
        ItemDto mockItem = new ItemDto(itemId, "Product1", "Description1", 100.0, 90.0, "Category1", "photo1.jpg", 10, true, false);
        when(itemService.getById(itemId)).thenReturn(mockItem);

        ItemDto response = itemController.getItemById(itemId);

        assertEquals(mockItem, response);
    }
}
