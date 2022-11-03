import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void testEquals() {
        Company branch_kappl = new Branch("MehrRettich", "Kappl");
        Company branch_landeck = new Branch("MehrRettich", "Landeck");
        Client marco = new Client("Marco","Cotrotzo",branch_kappl);
        Client jedin = new Client("Jedin","Müller",branch_kappl);
        Client mona = new Client("Mona", "Lisa", branch_landeck);
        Client mona2 = new Client("Mona", "Lisa", branch_landeck);

        assertFalse(marco.equals(jedin));
        assertFalse(jedin.equals(marco));
        assertTrue(mona.equals(mona2));
        assertFalse(marco.equals(null));
        assertTrue(marco.equals(marco));
    }

    @Test
    void updateProductStates() {
        Company branch_kappl = new Branch("MehrRettich", "Kappl");
        Client marco = new Client("Marco","Cotrotzo",branch_kappl);
        branch_kappl.followShop(marco);

        Product cucumber = new Product(Category.VEGETABLES, "Cucumber");
        Product tomato = new Product(Category.VEGETABLES, "Tomato");

        marco.updateProductStates(cucumber,ProductState.SOLDOUT);
        marco.updateProductStates(cucumber,ProductState.NEW);
        assertEquals(marco.returnFeed(), List.of("Cucumber is SOLDOUT!","Cucumber is NEW!"));


    }


}