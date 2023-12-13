package org.scrum.domain.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private boolean is_activated;
    private boolean is_deleted;

    public ItemDto(String productName, String description, double costPrice, double salePrice, String category, String photo, int currentQuantity, boolean is_activated, boolean is_deleted) {
        this.productName = productName;
        this.description = description;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.category = category;
        this.photo = photo;
        this.currentQuantity = currentQuantity;
        this.is_activated = is_activated;
        this.is_deleted = is_deleted;
    }
}
