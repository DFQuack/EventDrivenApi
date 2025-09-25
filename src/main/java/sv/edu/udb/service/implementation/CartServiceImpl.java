package sv.edu.udb.service.implementation;

import jakarta.persistence.EntityNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sv.edu.udb.controller.request.CartItemRequest;
import sv.edu.udb.controller.request.CartRequest;
import sv.edu.udb.controller.response.CartResponse;
import sv.edu.udb.repository.CartItemRepository;
import sv.edu.udb.repository.CartRepository;
import sv.edu.udb.repository.domain.Cart;
import sv.edu.udb.repository.domain.CartItem;
import sv.edu.udb.service.CartService;
import sv.edu.udb.service.mapper.CartItemMapper;
import sv.edu.udb.service.mapper.CartMapper;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    @NonNull
    private final CartRepository cartRepo;
    @NonNull
    private final CartMapper cartMapper;
    @NonNull
    private final CartItemMapper itemMapper;
    @NonNull
    private final CartItemRepository itemRepo;

    @Override
    public CartResponse findById(Long id) {
        return cartMapper.toCartResponse(cartRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Cart not found; id: " + id)));
    }

    @Override
    public CartResponse save(CartRequest cartRequest) {
        final Cart newCart = cartMapper.toCart(cartRequest);
        return cartMapper.toCartResponse(cartRepo.save(newCart));
    }

    @Override
    public CartResponse addItem(Long id, CartItemRequest itemRequest) {
        Cart cart = cartRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Cart not found; id: " + id));
        List<CartItem> cartItems = new ArrayList<>(cart.getCartItems());
        CartItem newItem = itemMapper.toCartItem(itemRequest);

        cartItems.add(newItem);
        cart.setCartItems(cartItems);
        newItem.setCart(cart);

        return cartMapper.toCartResponse(cartRepo.save(cart));
    }

    @Override
    public CartResponse removeItem(Long cartId, Long itemId) {
        Cart cart = cartRepo.findById(cartId).orElseThrow(() -> new EntityNotFoundException("Cart not found; id: " + cartId));
        List<CartItem> cartItems = new ArrayList<>(cart.getCartItems());
        CartItem itemToDelete = itemRepo.findById(itemId).orElseThrow(() -> new EntityNotFoundException("Item not found; id: " + itemId));

        cartItems.remove(itemToDelete);
        cart.setCartItems(cartItems);
        itemToDelete.setCart(null);

        return cartMapper.toCartResponse(cartRepo.save(cart));
    }

    @Override
    public void delete(Long id) {
        cartRepo.deleteById(id);
    }
}
