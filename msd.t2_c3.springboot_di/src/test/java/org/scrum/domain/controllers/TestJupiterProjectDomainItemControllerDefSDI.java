package org.scrum.domain.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.scrum.domain.project.Item;
import org.scrum.domain.services.ItemService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


//JUnit.5
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class TestJupiterProjectDomainItemControllerDefSDI {
	@Mock
	private ItemService itemService;

	@InjectMocks
	private ItemController itemController;

	private MockMvc mockMvc;

	@Test
	void getAllItems() throws Exception {
		List<Item> items = Arrays.asList(
				new Item("Example Product1", "This is an example product1", 15.0, 3.0, "Example Category1", "example1.jpg", 30),
				new Item("Example Product2", "This is an example product2", 10.0, 2.0, "Example Category2", "example2.jpg", 20)
		);

		when(itemService.getAllItems()).thenReturn(items);

		mockMvc = MockMvcBuilders.standaloneSetup(itemController).build();

		mockMvc.perform(get("/items/"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$").isArray())
				.andExpect(jsonPath("$.length()").value(items.size()));
	}

	@Test
	void addItem() throws Exception {
		Item newItem = new Item("Example Product", "This is an example product", 10.0, 2.0, "Example Category", "example.jpg", 20);
		when(itemService.addItem(any())).thenReturn(newItem);

		mockMvc = MockMvcBuilders.standaloneSetup(itemController).build();

		ObjectMapper objectMapper = new ObjectMapper();
		String newItemJson = objectMapper.writeValueAsString(newItem);

		mockMvc.perform(post("/items/addItem")
						.contentType(MediaType.APPLICATION_JSON)
						.content(newItemJson))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id").exists());
	}
}