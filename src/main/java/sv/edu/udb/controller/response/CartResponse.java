package sv.edu.udb.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;
import sv.edu.udb.repository.domain.CartItem;

import java.util.List;

@Getter
@Setter
@Builder(toBuilder = true)
@FieldNameConstants
public class CartResponse {
    private Long id;
    private List<CartItem> items;
}
