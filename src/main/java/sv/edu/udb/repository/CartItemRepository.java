package sv.edu.udb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.repository.domain.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
