package org.scrum.domain.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.scrum.domain.project.Order;
import org.scrum.domain.project.OrderDetail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Integer orderId;
    private List<OrderDetailDto> orderDetailList;
    private double totalPrice;
    private Date dateOrder;
    private Date deliveryDate;
    private String status;
    private double tax;
    private int quantity;
    private boolean isAccept;

    public OrderDto(Order order) {
        this.orderId = order.getOrderId();
        totalPrice = order.getTotalPrice();
        dateOrder = order.getDateOrder();
        deliveryDate = order.getDeliveryDate();
        status = order.getStatus();
        tax = order.getTax();
        quantity = order.getQuantity();
        isAccept = order.isAccept();
        orderDetailList = convertToDto(order.getOrderDetailList());
    }

    private List<OrderDetailDto> convertToDto(List<OrderDetail> orderDetailList) {
        List<OrderDetailDto> orderDetailDtos = new ArrayList<>();
        for (OrderDetail orderDetail : orderDetailList) {
            OrderDetailDto orderDetailDto = new OrderDetailDto(orderDetail);
            orderDetailDtos.add(orderDetailDto);
        }
        return orderDetailDtos;
    }
}
