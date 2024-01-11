package org.scrum.domain.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.scrum.domain.controllers.ItemController;
import org.scrum.domain.project.Item;
import org.scrum.domain.project.dto.ItemDto;
import org.scrum.domain.services.ItemService;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class ItemControllerTest {

    @Mock
    private ItemService itemService;

    @InjectMocks
    private ItemController itemController;

    private final MockMvc mockMvc;

    public ItemControllerTest() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(itemController).build();
    }

    @Test
    void testGetAllItems() throws Exception {
        ItemDto itemDto1 = new ItemDto(1, "Product1", "Description1", 50.0, 80.0, "Category1", "photo1.jpg", 100, true, false);
        ItemDto itemDto2 = new ItemDto(2, "Product2", "Description2", 60.0, 90.0, "Category2", "photo2.jpg", 150, true, false);

        Mockito.when(itemService.getAllItems()).thenReturn(Arrays.asList(itemDto1, itemDto2));

        mockMvc.perform(get("/items/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].productName").value("Product1"))
                .andExpect(jsonPath("$[1].productName").value("Product2"));
    }
}
