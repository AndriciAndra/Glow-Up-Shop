package org.scrum.domain.project;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.scrum.domain.project.dto.ItemDto;

@Getter
@Setter
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
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

    public Item(String productName,
                String description,
                double costPrice,
                double salePrice,
                String category,
                String photo,
                int currentQuantity,
                boolean isActivated,
                boolean isDeleted) {
        this.productName = productName;
        this.description = description;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.category = category;
        this.photo = photo;
        this.currentQuantity = currentQuantity;
        this.isActivated = isActivated;
        this.isDeleted = isDeleted;
    }

    public Item() {
    }

    public void copyItem(ItemDto item) {
        this.productName = item.getProductName();
        this.description = item.getDescription();
        this.costPrice = item.getCostPrice();
        this.salePrice = item.getSalePrice();
        this.category = item.getCategory();
        this.currentQuantity = item.getCurrentQuantity();
        this.isActivated = item.isActivated();
        this.isDeleted = item.isDeleted();
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", description='" + description + '\'' +
                ", costPrice=" + costPrice +
                ", salePrice=" + salePrice +
                ", category='" + category + '\'' +
                ", photo='" + photo + '\'' +
                ", currentQuantity=" + currentQuantity +
                ", is_activated=" + isActivated +
                ", is_deleted=" + isDeleted +
                '}';
    }
}
