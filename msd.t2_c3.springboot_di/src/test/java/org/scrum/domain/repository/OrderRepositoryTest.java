package org.scrum.domain.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.scrum.domain.project.Order;
import org.scrum.domain.repositories.OrderRepository;

import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class OrderRepositoryTest {

    @Mock
    private OrderRepository orderRepository;

    @Test
    public void testGetAllOrders() {

        Order order1 = new Order(/*prop comenzii*/);
        Order order2 = new Order(/*prop comenzii*/);
        Order order3 = new Order(/*prop comenzii*/);

        when(orderRepository.getAllOrders()).thenReturn(List.of(order1, order2, order3));

        List<Order> result = orderRepository.getAllOrders();

        verify(orderRepository, times(1)).getAllOrders();

        assertEquals(3, result.size());
    }

}
