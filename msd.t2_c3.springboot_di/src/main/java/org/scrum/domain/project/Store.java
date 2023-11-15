package org.scrum.domain.project;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Store {
    @JsonProperty("saleId")
    private int saleId;

    @JsonProperty("productName")
    private String productName;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("totalPrice")
    private double totalPrice;

    public int getSaleId()
    {
        return saleId;
    }
    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }
}
