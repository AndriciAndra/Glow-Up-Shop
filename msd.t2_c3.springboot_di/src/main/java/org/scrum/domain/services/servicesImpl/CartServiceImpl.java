package org.scrum.domain.services.servicesImpl;

import lombok.RequiredArgsConstructor;
import org.scrum.domain.project.Cart;
import org.scrum.domain.project.CartItem;
import org.scrum.domain.project.Client;
import org.scrum.domain.project.Item;
import org.scrum.domain.project.dto.CartDto;
import org.scrum.domain.project.dto.CartItemDto;
import org.scrum.domain.project.dto.ItemDto;
import org.scrum.domain.repositories.CartItemRepository;
import org.scrum.domain.repositories.CartRepository;
import org.scrum.domain.services.CartService;
import org.scrum.domain.services.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.*;


@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ClientService clientService;

    @Override
    public ResponseEntity<Object> addItemToCart(ItemDto itemDto, int quantity, String username) {
        Client client = clientService.findByUsername(username);
        Cart cart = client.getCart();

        if (cart == null) {
            cart = new Cart();
        }
        Set<CartItem> cartItemList = cart.getCartItems();
        CartItem cartItem = find(cartItemList, itemDto.getId());
        Item Item = transfer(itemDto);

        double unitPrice;
        if (itemDto.getSalePrice() == 0.0)
            unitPrice = itemDto.getCostPrice();
        else
            unitPrice = itemDto.getSalePrice();

        int itemQuantity;
        if (cartItemList == null) {
            cartItemList = new HashSet<>();
        }
        if (cartItem == null) {
            cartItem = new CartItem();
            cartItem.setItem(Item);
            cartItem.setCart(cart);
            cartItem.setQuantity(quantity);
            cartItem.setPrice(unitPrice);
            cartItem.setCart(cart);
            cartItemList.add(cartItem);
            cartItemRepository.save(cartItem);
        } else {
            itemQuantity = cartItem.getQuantity() + quantity;
            cartItem.setQuantity(itemQuantity);
            cartItemRepository.save(cartItem);
        }
        cart.setCartItems(cartItemList);

        double totalPrice = totalPrice(cart.getCartItems());
        int totalItem = totalItem(cart.getCartItems());

        cart.setTotalPrice(totalPrice);
        cart.setTotalItems(totalItem);
        cart.setClient(client);
        cartRepository.save(cart);
        return new ResponseEntity<>("Item added to cart successfully!", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> updateCart(ItemDto itemDto, int quantity, String username) {
        Client customer = clientService.findByUsername(username);
        Cart shoppingCart = customer.getCart();
        Set<CartItem> cartItemList = shoppingCart.getCartItems();
        CartItem item = find(cartItemList, itemDto.getId());

        item.setQuantity(quantity);
        cartItemRepository.save(item);
        shoppingCart.setCartItems(cartItemList);
        int totalItem = totalItem(cartItemList);
        double totalPrice = totalPrice(cartItemList);
        shoppingCart.setTotalPrice(totalPrice);
        shoppingCart.setTotalItems(totalItem);
        cartRepository.save(shoppingCart);
        return new ResponseEntity<>("Cart updated!", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> removeItemFromCart(int itemId, String username) {
        Client client = clientService.findByUsername(username);
        Cart shoppingCart = client.getCart();
        Set<CartItem> cartItemList = shoppingCart.getCartItems();
        CartItem item = find(cartItemList, itemId);
        cartItemList.remove(item);
        cartItemRepository.delete(item);
        double totalPrice = totalPrice(cartItemList);
        int totalItem = totalItem(cartItemList);
        shoppingCart.setCartItems(cartItemList);
        shoppingCart.setTotalPrice(totalPrice);
        shoppingCart.setTotalItems(totalItem);
        cartRepository.save(shoppingCart);
        return new ResponseEntity<>("Item deleted from cart successfully!", HttpStatus.OK);
    }

    @Override
    public void deleteCartById(int id) {
        Optional<Cart> cart = cartRepository.findById(id);
        if (cart.isPresent()) {
            if (!ObjectUtils.isEmpty(cart) && !ObjectUtils.isEmpty(cart.get().getCartItems())) {
                cartItemRepository.deleteCartItemBy(id);
            }
            cartRepository.updateCartById(id);
        }
    }

    @Override
    public Cart getCart(String username) {
        Client client = clientService.findByUsername(username);
        return client.getCart();
    }

    private CartItem find(Set<CartItem> cartItems, int productId) {
        if (cartItems == null) {
            return null;
        }
        CartItem cartItem = null;
        for (CartItem item : cartItems) {
            if (item.getItem().getId() == productId) {
                cartItem = item;
            }
        }
        return cartItem;
    }

    private double totalPrice(Set<CartItem> cartItemList) {
        double totalPrice = 0.0;
        for (CartItem item : cartItemList) {
            totalPrice += item.getPrice() * item.getQuantity();
        }
        return totalPrice;
    }

    private int totalItem(Set<CartItem> cartItemList) {
        int totalItem = 0;
        for (CartItem item : cartItemList) {
            totalItem += item.getQuantity();
        }
        return totalItem;
    }

    private Item transfer(ItemDto productDto) {
        Item product = new Item();
        product.setId(productDto.getId());
        product.setProductName(productDto.getProductName());
        product.setCurrentQuantity(productDto.getCurrentQuantity());
        product.setCostPrice(productDto.getCostPrice());
        product.setSalePrice(productDto.getSalePrice());
        product.setDescription(productDto.getDescription());
        product.setPhoto(productDto.getPhoto());
        product.setActivated(productDto.isActivated());
        product.setDeleted(productDto.isDeleted());
        product.setCategory(productDto.getCategory());
        return product;
    }

    private Set<CartItem> convertCartItem(Set<CartItemDto> cartItemDtos, Cart cart) {
        Set<CartItem> cartItems = new HashSet<>();
        for (CartItemDto cartItemDto : cartItemDtos) {
            CartItem cartItem = new CartItem();
            cartItem.setQuantity(cartItemDto.getQuantity());
            cartItem.setItem(transfer(cartItemDto.getItem()));
            cartItem.setPrice(cartItemDto.getPrice());
            cartItem.setId(cartItemDto.getId());
            cartItem.setCart(cart);
            cartItems.add(cartItem);
        }
        return cartItems;
    }

    public CartDto convertCartToCartDto(Cart cart) {
        CartDto cartDto = new CartDto();
        cartDto.setId(cart.getId());
        cartDto.setTotalItems(cart.getTotalItems());
        cartDto.setTotalPrice(cart.getTotalPrice());

        Set<CartItemDto> cartItemsDto = new HashSet<>();
        for (CartItem cartItem : cart.getCartItems()) {
            CartItemDto cartItemDto = new CartItemDto();
            cartItemDto.setQuantity(cartItem.getQuantity());
            cartItemDto.setPrice(cartItem.getPrice());
            cartItemDto.setId(cartItem.getId());
            cartItemDto.setItem(new ItemDto(cartItem.getItem()));
            cartItemsDto.add(cartItemDto);
        }
        cartDto.setCartItems(cartItemsDto);
        return cartDto;
    }
}
