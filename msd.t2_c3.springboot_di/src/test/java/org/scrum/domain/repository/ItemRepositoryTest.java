package org.scrum.domain.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.scrum.domain.project.Item;
import org.scrum.domain.repositories.ItemRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ItemRepositoryTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemRepositoryTest itemRepositoryTest;

    @Test
    void testGetAllItem() {
        List<Item> items = List.of(
                new Item("Product1", "Description1", 10.0, 5.0, "Category1", "Photo1", 50, true, false),
                new Item("Product2", "Description2", 20.0, 8.0, "Category2", "Photo2", 30, true, false)
        );

        when(itemRepository.getAllItem()).thenReturn(items);

        List<Item> result = itemRepository.getAllItem();

        assertThat(result).hasSize(2);
        assertThat(result.get(0).getProductName()).isEqualTo("Product1");
        assertThat(result.get(1).getProductName()).isEqualTo("Product2");

        verify(itemRepository, times(1)).getAllItem();
    }

    @Test
    void testFindAllByCategory() {
        String category = "Category1";
        List<Item> items = List.of(
                new Item("Product1", "Description1", 10.0, 5.0, "Category1", "Photo1", 50, true, false),
                new Item("Product3", "Description3", 15.0, 7.0, "Category1", "Photo3", 40, true, false)
        );

        when(itemRepository.findAllByCategory(category)).thenReturn(items);

        List<Item> result = itemRepository.findAllByCategory(category);

        assertThat(result).hasSize(2);
        assertThat(result.get(0).getProductName()).isEqualTo("Product1");
        assertThat(result.get(1).getProductName()).isEqualTo("Product3");

        verify(itemRepository, times(1)).findAllByCategory(category);
    }

}
