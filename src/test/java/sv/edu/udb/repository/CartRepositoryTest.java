package sv.edu.udb.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CartRepositoryTest {
    @Autowired
    private CartRepository cartRepo;

    void init() {
        final String name = "Headphones";
        final String itemCategory = "Electronics";
        final Double price = 30.00;
    }
}
