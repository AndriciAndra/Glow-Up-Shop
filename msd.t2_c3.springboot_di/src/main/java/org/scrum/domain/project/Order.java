package org.scrum.domain.project;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Order {
    @JsonProperty("orderId")
    private int orderId;

    @JsonProperty("nameClient")
    private String nameClient;

    @JsonProperty("items")
    private List<Item> items;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("dateOrder")
    private String dateOrder;

    @JsonProperty("totalPrice")
    private double totalPrice;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
