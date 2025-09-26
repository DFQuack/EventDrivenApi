package sv.edu.udb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sv.edu.udb.controller.request.CartItemRequest;
import sv.edu.udb.controller.request.CartRequest;
import sv.edu.udb.controller.response.CartResponse;
import sv.edu.udb.event.CartEventProducer;
import sv.edu.udb.service.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;
    private final CartEventProducer eventProducer;

    public CartController(CartService cartService, CartEventProducer eventProducer) {
        this.cartService = cartService;
        this.eventProducer = eventProducer;
    }

    @PostMapping
    public ResponseEntity<CartResponse> createCart(@RequestBody CartRequest request) {
        CartResponse response = cartService.save(request);
        eventProducer.sendEvent("CREATED_CART", response);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartResponse> getCart(@PathVariable Long id) {
        CartResponse response = cartService.findById(id);
        if (response == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{id}/add")
    public ResponseEntity<CartResponse> addItem(@PathVariable Long id, @RequestBody CartItemRequest itemRequest) {
        CartResponse response = cartService.addItem(id, itemRequest);
        eventProducer.sendEvent("ADDED_ITEM", response);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}/{itemId}")
    public ResponseEntity<CartResponse> removeItem(@PathVariable Long id, @PathVariable Long itemId) {
        CartResponse response = cartService.removeItem(id, itemId);
        eventProducer.sendEvent("REMOVED_ITEM", response);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long id) {
        cartService.delete(id);
        eventProducer.sendEvent("DELETED_CART", id);
        return ResponseEntity.noContent().build();
    }
}
