package org.scrum.domain.services.servicesImpl;

import lombok.RequiredArgsConstructor;
import org.scrum.domain.project.Cart;
import org.scrum.domain.repositories.CartItemRepository;
import org.scrum.domain.repositories.CartRepository;
import org.scrum.domain.services.CartService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    @Override
    public void deleteCartById(int id) {
        Cart cart = cartRepository.getReferenceById(id);
        if(!ObjectUtils.isEmpty(cart) && !ObjectUtils.isEmpty(cart.getCartItems())){
            cartItemRepository.deleteAll(cart.getCartItems());
        }
        cart.getCartItems().clear();
        cart.setTotalPrice(0);
        cart.setTotalItems(0);
        cartRepository.save(cart);
    }
}
