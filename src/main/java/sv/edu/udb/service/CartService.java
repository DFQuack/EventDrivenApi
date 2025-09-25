package sv.edu.udb.service;

import sv.edu.udb.controller.request.CartItemRequest;
import sv.edu.udb.controller.request.CartRequest;
import sv.edu.udb.controller.response.CartResponse;

public interface CartService {
    CartResponse findById(final Long id);
    CartResponse save(final CartRequest cartRequest);
    CartResponse addItem(final Long id, final CartItemRequest itemRequest);
    CartResponse removeItem(final Long id, final CartItemRequest itemRequest);
    void delete(final Long id);
}
