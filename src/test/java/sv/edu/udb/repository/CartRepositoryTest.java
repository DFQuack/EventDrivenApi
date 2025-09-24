package sv.edu.udb.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import sv.edu.udb.repository.domain.Cart;
import sv.edu.udb.repository.domain.CartItem;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class CartRepositoryTest {
    @Autowired
    private CartRepository cartRepo;
    @Autowired
    private CartItemRepository itemRepo;

    @BeforeEach
    void init() {
        final Long itemId = 1L;
        final int quantity = 1;
        final Double totalPrice = 30.00;
        CartItem newItem = CartItem.builder()
                .itemId(itemId)
                .quantity(quantity)
                .totalPrice(totalPrice)
                .build();

        Cart newCart = Cart.builder()
                .cartItems(List.of(newItem))
                .build();

        newItem.setCart(newCart);
        cartRepo.save(newCart);
    }

    @AfterEach
    void clean() {
        cartRepo.deleteAll();
    }

    @Test
    void findAllHasOneCart() {
        final int expectedCartNum = 1;
        final List<Cart> actualCartList = cartRepo.findAll();

        assertNotNull(actualCartList);
        assertEquals(expectedCartNum, actualCartList.size());
    }

    @Test
    void findByIdGetsCart() {
        final Long expectedId = 1L;
        final Long expectedItemId = 1L;
        final int expectedQuantity = 1;
        final Double expectedTotalPrice = 30.00;

        final Cart actualCart = cartRepo.findById(expectedId).orElse(null);
        assertNotNull(actualCart);
        assertEquals(expectedId, actualCart.getId());
        assertEquals(expectedItemId, actualCart.getCartItems().get(0).getItemId());
        assertEquals(expectedQuantity, actualCart.getCartItems().get(0).getQuantity());
        assertEquals(expectedTotalPrice, actualCart.getCartItems().get(0).getTotalPrice());
    }
}
