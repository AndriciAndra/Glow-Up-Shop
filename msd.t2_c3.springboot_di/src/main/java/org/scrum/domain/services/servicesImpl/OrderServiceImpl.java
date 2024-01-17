package org.scrum.domain.services.servicesImpl;

import lombok.RequiredArgsConstructor;
import org.scrum.domain.project.*;
import org.scrum.domain.project.dto.OrderDto;
import org.scrum.domain.repositories.OrderRepository;
import org.scrum.domain.repositories.OrderDetailRepository;
import org.scrum.domain.services.CartService;
import org.scrum.domain.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final CartService cartService;

    @Override
    public ResponseEntity<Object> addOrder(Cart cart) {
        Order order = new Order(cart.getClient(), cart.getTotalPrice(), new Date(), "Pending", 2, cart.getTotalItems(), false);
        List<OrderDetail> orderDetailList = new ArrayList<>();
        for (CartItem item : cart.getCartItems()) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(order);
            orderDetail.setItem(item.getItem());
            orderDetail.setTotalQuantity(item.getQuantity());
            orderDetail.setTotalPrice(item.getPrice()* item.getQuantity());
            orderDetailRepository.save(orderDetail);
            orderDetailList.add(orderDetail);
        }
        order.setOrderDetailList(orderDetailList);
        cartService.deleteCartById(cart.getId());
        orderRepository.save(order);
        return new ResponseEntity<>("Order sent!", HttpStatus.CREATED);
    }

    @Override
    public List<OrderDto> getOrdersByClient(int id) {
        return transferData(orderRepository.getAllOrdersByClientId(id));
    }

    private List<OrderDto> transferData(List<Order> orders) {
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orders) {
            OrderDto orderDto = new OrderDto(order);
            orderDtos.add(orderDto);
        }
        return orderDtos;
    }

    @Override
    public ResponseEntity<Object> acceptOrder(int id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isEmpty())
            return new ResponseEntity<>("Order not found!", HttpStatus.GONE);
        order.get().setAccept(true);
        order.get().setDeliveryDate(new Date());
        order.get().setStatus("In delivery");
        orderRepository.save(order.get());
        return new ResponseEntity<>("Order accepted!", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> cancelOrder(int id) {
        Optional<Order> order = orderRepository.findById(id);
        if (order.isEmpty())
            return new ResponseEntity<>("Order not found!", HttpStatus.GONE);
        orderRepository.deleteById(id);
        return new ResponseEntity<>("Order deleted!", HttpStatus.OK);
    }
}
