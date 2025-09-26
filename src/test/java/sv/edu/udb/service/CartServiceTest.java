package sv.edu.udb.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import sv.edu.udb.controller.request.CartItemRequest;
import sv.edu.udb.controller.request.CartRequest;
import sv.edu.udb.controller.response.CartResponse;
import sv.edu.udb.repository.CartItemRepository;
import sv.edu.udb.repository.CartRepository;
import sv.edu.udb.repository.domain.Cart;
import sv.edu.udb.repository.domain.CartItem;
import sv.edu.udb.service.implementation.CartServiceImpl;
import sv.edu.udb.service.mapper.CartItemMapper;
import sv.edu.udb.service.mapper.CartMapper;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DataJpaTest
@ExtendWith(MockitoExtension.class)
public class CartServiceTest {
    /*
    @Mock
    private CartRepository cartRepo;
    @Mock
    private CartMapper cartMapper;
    @Mock
    private CartItemRepository itemRepo;
    @Mock
    private CartItemMapper itemMapper;

    @InjectMocks
    private CartServiceImpl cartService;

    private Cart cart;
    private CartResponse cartResponse;
    private CartRequest cartRequest;
    private CartItem cartItem;
    private CartItemRequest itemRequest;

    @BeforeEach
    void setup() {
        final Long expectedId = 1L;
        final Long itemId = 1L;
        final int quantity = 1;
        final Double totalPrice = 30.00;

        cartItem = CartItem.builder()
                .id(expectedId)
                .itemId(itemId)
                .quantity(quantity)
                .totalPrice(totalPrice)
                .build();
        cart = Cart.builder()
                .id(expectedId)
                .cartItems(List.of(cartItem))
                .build();
        cartItem.setCart(cart);

        itemRequest = CartItemRequest.builder()
                .itemId(itemId)
                .quantity(quantity)
                .totalPrice(totalPrice)
                .build();

        cartRequest = CartRequest.builder().items(List.of(cartItem)).build();

        cartResponse = CartResponse.builder()
                .id(expectedId)
                .items(List.of(cartItem))
                .build();
    }

    @AfterEach
    void clean() {
        cartRepo.deleteAll();
    }

    @Test
    void findByIdGetsCart() {
        final Long expectedId = 1L;
        final Long expectedItemId = 1L;
        final int expectedQuantity = 1;
        final Double expectedTotalPrice = 30.00;

        when(cartRepo.findById(expectedId)).thenReturn(Optional.of(cart));
        when(cartMapper.toCartResponse(cart)).thenReturn(cartResponse);
        when(cartService.findById(expectedId)).thenReturn(cartResponse);
        CartResponse response = cartService.findById(expectedId);

        assertNotNull(response);
        assertEquals(expectedId, response.getId());
        assertEquals(expectedItemId, response.getItems().get(0).getItemId());
        assertEquals(expectedQuantity, response.getItems().get(0).getQuantity());
        assertEquals(expectedTotalPrice, response.getItems().get(0).getTotalPrice());
    }
    */
}
