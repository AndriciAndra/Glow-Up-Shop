package org.scrum.domain.project;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Integer orderId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client clientId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    private List<OrderDetail> orderDetailList;

    private double totalPrice;

    private Date dateOrder;

    private Date deliveryDate;

    private String status;

    private double tax;

    private int quantity;

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
