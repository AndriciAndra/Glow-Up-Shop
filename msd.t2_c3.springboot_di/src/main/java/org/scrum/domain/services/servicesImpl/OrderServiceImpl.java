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
    public ResponseEntity<Object> getAllOrders() {
        List<Order> orderList = orderRepository.getAllOrders();
        System.out.println(orderList.get(0));
        if (orderList.isEmpty())
            return new ResponseEntity<>("Orders not found!", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(orderList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> acceptOrder(int id) {
        Optional<Order> order = orderRepository.findById(id);
        if(order.isEmpty())
            return new ResponseEntity<>("Order not found!", HttpStatus.GONE);
        order.get().setAccept(true);
        order.get().setDeliveryDate(new Date());
        orderRepository.save(order.get());
        return new ResponseEntity<>("Order accepted!", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> cancelOrder(int id) {
        Optional<Order> order = orderRepository.findById(id);
        if(order.isEmpty())
            return new ResponseEntity<>("Order not found!", HttpStatus.GONE);
        orderRepository.deleteById(id);
        return new ResponseEntity<>("Order deleted!", HttpStatus.OK);
    }
}
