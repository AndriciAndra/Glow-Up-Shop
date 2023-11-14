package org.scrum.domain.project;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Item {
    @JsonProperty("id")
    private int id;

    @JsonProperty("productName")
    private String productName;

    @JsonProperty("description")
    private String description;

    @JsonProperty("costPrice")
    private Double costPrice;

    @JsonProperty("salePrice")
    private Double salePrice;

    @JsonProperty("category")
    private String category;

    @JsonProperty("photo")
    private String photo;

    @JsonProperty("currentQuantity")
    private int currentQuantity;

    public Item() {

    }

    public Item(String productName,
                String description,
                double costPrice,
                double salePrice,
                String category,
                String photo,
                int currentQuantity) {
        this.productName = productName;
        this.description = description;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.category = category;
        this.photo = photo;
        this.currentQuantity = currentQuantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
