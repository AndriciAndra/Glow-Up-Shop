package org.scrum.domain.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.scrum.domain.project.Item;
import org.scrum.domain.project.dto.ItemDto;
import org.scrum.domain.repositories.ItemRepository;
import org.scrum.domain.services.servicesImpl.ItemServiceImpl;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TestJupiterProjectDomainItemServiceDefSDI {
    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemServiceImpl itemService;

    @Test
    void testAddItem() {
        // Arrange
        ItemDto itemToAdd = new ItemDto();

        // Act
        Item addedItem = itemService.addItem(itemToAdd);

        // Assert
        assertEquals("Example Product1", addedItem.getProductName());
        assertEquals(2, addedItem.getId());

    }

    @Test
    void testGetAllItems() {
        // Arrange
        ItemDto item1 = new ItemDto("Example Product1", "This is an example product1", 15.0, 3.0, "skincare", "example1.jpg", 30, true, false);

        ItemDto item2 = new ItemDto("Example Product2", "This is an example product2", 10.0, 2.0, "skincare", "example2.jpg", 20, true, false);

        itemService.addItem(item1);
        itemService.addItem(item2);

        // Mock the findAll method of the repository
        //when(itemRepository.findAll()).thenReturn((List<ItemDto>) Arrays.asList(item1, item2));

        // Act
        List<Item> retrievedItems = itemService.getAllItems();

        // Verify that the findAll method of the repository was called
        verify(itemRepository).findAll();

        // Assert
        assertEquals(2, retrievedItems.size());
        assertEquals("Example Product1", retrievedItems.get(0).getProductName());
        assertEquals("Example Product2", retrievedItems.get(1).getProductName());
    }
}
