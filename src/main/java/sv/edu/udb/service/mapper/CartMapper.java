package sv.edu.udb.service.mapper;

import org.mapstruct.Mapper;
import sv.edu.udb.controller.request.CartRequest;
import sv.edu.udb.controller.response.CartResponse;
import sv.edu.udb.repository.domain.Cart;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartResponse toCartResponse(final Cart cart);
    Cart toCart(final CartRequest cartRequest);
}