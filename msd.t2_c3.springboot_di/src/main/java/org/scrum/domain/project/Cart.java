package org.scrum.domain.project;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;

    private double totalPrice;

    private int totalItems;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "cart")
    private Set<CartItem> cartItems;

    public Cart() {
        this.cartItems = new HashSet<>();
        this.totalItems = 0;
        this.totalPrice = 0.0;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", client=" + client.getClient_id() + // Exclude the client field here
                ", totalPrice=" + totalPrice +
                ", totalItems=" + totalItems +
                ", cartItems=" + cartItems +
                '}';
    }
}
