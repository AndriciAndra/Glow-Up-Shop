package org.scrum.domain.services.servicesImpl;

import lombok.RequiredArgsConstructor;
import org.scrum.domain.project.Cart;
import org.scrum.domain.project.CartItem;
import org.scrum.domain.project.Order;
import org.scrum.domain.project.OrderDetail;
import org.scrum.domain.repositories.OrderRepository;
import org.scrum.domain.repositories.OrderDetailRepository;
import org.scrum.domain.services.CartService;
import org.scrum.domain.services.OrderService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final CartService cartService;

    @Override
    public Order addOrder(Cart cart) {
        Order order = new Order(cart.getClient(), cart.getTotalPrice(), new Date(), "Pending", 2, cart.getTotalItems(), false);
        List<OrderDetail> orderDetailList = new ArrayList<>();
        for (CartItem item : cart.getCartItems()) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(order);
            orderDetail.setItem(item.getItem());
            orderDetailRepository.save(orderDetail);
            orderDetailList.add(orderDetail);
        }
        order.setOrderDetailList(orderDetailList);
        cartService.deleteCartById(cart.getId());
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
