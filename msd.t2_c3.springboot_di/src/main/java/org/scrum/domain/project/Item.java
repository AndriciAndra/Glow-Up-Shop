package org.scrum.domain.project;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "item")
public class Item {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Getter
    private String productName;

    @Getter
    private String description;

    @Getter
    private double costPrice;

    @Getter
    private double salePrice;

    @Getter
    private String category;

    @Getter
    private String photo;

    @Getter
    private int currentQuantity;

    private boolean is_activated;

    private boolean is_deleted;

    public Item() {

    }

    public Item(String productName,
                String description,
                double costPrice,
                double salePrice,
                String category,
                String photo,
                int currentQuantity,
                boolean is_activated,
                boolean is_deleted) {
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
                ", is_activated=" + is_activated +
                ", is_deleted=" + is_deleted +
                '}';
    }
}
