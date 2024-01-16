package org.scrum.domain.project;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    private int totalQuantity;
    private double totalPrice;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private Order orderId;

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", totalQuantity=" + totalQuantity +
                ", totalPrice=" + totalPrice +
                ", item=" + item +
                ", orderId=" + orderId +
                '}';
    }
}
