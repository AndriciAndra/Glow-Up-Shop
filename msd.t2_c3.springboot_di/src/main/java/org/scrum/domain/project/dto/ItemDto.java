package org.scrum.domain.project.dto;

import lombok.*;
import org.scrum.domain.project.Item;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {
    private Integer id;
    private String productName;
    private String description;
    private double costPrice;
    private double salePrice;
    private String category;
    private String photo;
    private int currentQuantity;
    private boolean isActivated;
    private boolean isDeleted;

    public ItemDto(Item item) {
        this.id = item.getId();
        this.productName = item.getProductName();
        this.description = item.getDescription();
        this.costPrice = item.getCostPrice();
        this.salePrice = item.getSalePrice();
        this.category = item.getCategory();
        this.photo = item.getPhoto();
        this.currentQuantity = item.getCurrentQuantity();
        this.isActivated = item.isActivated();
        this.isDeleted = item.isDeleted();
    }
}
