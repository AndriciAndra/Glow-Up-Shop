package org.scrum.domain.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.scrum.domain.project.CartItem;
import org.scrum.domain.project.Client;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDto {
    private Integer id;
    private Client client;
    private double totalPrice;
    private int totalItems;
    private Set<CartItem> cartItems;
}
