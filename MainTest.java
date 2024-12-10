import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private Checkout checkout;

    @BeforeEach
    void setUp() {
        checkout = new Checkout();
        checkout.addProduct(new Product("A", 40, 3, 70));
        checkout.addProduct(new Product("B", 10, 2, 15));
    }

    @Test
    void testSingleProductWithoutMultiPrice() {
        checkout.scan("A");
        assertEquals(40, checkout.getTotal(), "Single product 'A' price should be 40");
    }

    @Test
    void testSingleProductWithMultiPrice() {
        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");
        assertEquals(70, checkout.getTotal(), "3 products 'A' cost 70, multi-price has been applied");
    }

    @Test
    void testMixedProductsWithMultiPrice() {
        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("B");
        checkout.scan("B");
        assertEquals(85, checkout.getTotal(), "Total price expected to be 85");
    }

    @Test
    void testUnknownProduct() {
        checkout.scan("X");
        assertEquals(0, checkout.getTotal(), "Unknown product, price won't change");
    }

    @Test
    void testEmptyCart() {
        assertEquals(0, checkout.getTotal(), "Empty cart should have total price 0");
    }
}
