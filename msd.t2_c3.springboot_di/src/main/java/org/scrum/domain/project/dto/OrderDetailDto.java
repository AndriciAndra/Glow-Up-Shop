package org.scrum.domain.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.scrum.domain.project.OrderDetail;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDto {
    private Integer id;
    private int totalQuantity;
    private double totalPrice;
    private ItemDto item;

    public OrderDetailDto(OrderDetail orderDetail) {
        id = orderDetail.getId();
        totalQuantity = orderDetail.getTotalQuantity();
        totalPrice = orderDetail.getTotalPrice();
        item = new ItemDto(orderDetail.getItem());
    }
}
