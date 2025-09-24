package sv.edu.udb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sv.edu.udb.repository.domain.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
