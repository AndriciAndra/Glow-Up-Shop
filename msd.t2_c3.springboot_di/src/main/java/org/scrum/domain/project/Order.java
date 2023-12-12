package org.scrum.domain.project;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private int orderId;

    @Getter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client clientId;

    @Getter
    @Setter
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    @JoinColumn(name = "id")
    private List<OrderDetail> orderDetailList;

    @Getter
    private double totalPrice;

    @Getter
    private Date dateOrder;

    @Getter
    private Date deliveryDate;

    @Getter
    private String status;

    @Getter
    private double tax;

    @Getter
    private int quantity;

    @Getter
    private boolean isAccept;

    public Order(Client clientId, double totalPrice, Date dateOrder, String status, double tax, int quantity, boolean isAccept) {
        this.clientId = clientId;
        this.totalPrice = totalPrice;
        this.dateOrder = dateOrder;
        this.status = status;
        this.tax = tax;
        this.quantity = quantity;
        this.isAccept = isAccept;
    }

    public Order() {

    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", clientId=" + clientId +
                ", orderDetailList=" + orderDetailList +
                ", totalPrice=" + totalPrice +
                ", dateOrder=" + dateOrder +
                ", deliveryDate=" + deliveryDate +
                ", status='" + status + '\'' +
                ", tax=" + tax +
                ", quantity=" + quantity +
                ", isAccept=" + isAccept +
                '}';
    }
}
