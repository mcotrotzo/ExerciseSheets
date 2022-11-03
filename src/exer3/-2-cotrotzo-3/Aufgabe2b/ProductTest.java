import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void getCategory() {

        Product cucumber = new Product(Category.VEGETABLES, "Cucumber");
        Product tomato = new Product(Category.FRUITS, "Tomato");

        assertEquals(cucumber.getCategory(), Category.VEGETABLES);
        assertEquals(tomato.getCategory(), Category.FRUITS);
    }

    @Test
    void testEquals() {
        Product cucumber = new Product(Category.VEGETABLES, "Cucumber");
        Product tomato = new Product(Category.FRUITS, "Tomato");
        Product cucumber1 = new Product(Category.VEGETABLES, "Cucumber");
        Product bean = new Product(Category.FRUITS, "Bean");

        assertFalse(cucumber.equals(tomato));
        assertFalse(cucumber.equals(null));
        assertTrue(cucumber.equals(cucumber1));
        assertFalse(bean.equals(cucumber1));
    }
}