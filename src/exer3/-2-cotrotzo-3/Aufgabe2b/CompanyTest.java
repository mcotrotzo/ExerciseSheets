import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.EmptyStackException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompanyTest {

    @Test
    @DisplayName("Follow shop altough customer is already in shop")
    void followShopAlreadyInShop() {
        Company branch_kappl = new Branch("MehrRettich", "Kappl");
        Company branch_landeck = new Branch("MehrRettich", "Landeck");
        Client marco = new Client("Marco","Cotrotzo",branch_kappl);
        Client jedin = new Client("Jedin","Müller",branch_kappl);
        Client mona = new Client("Mona", "Lisa", branch_landeck);
        branch_kappl.followShop(marco);
        assertThrows(InvalidParameterException.class, ()->branch_kappl.followShop(marco));
    }

    @Test
    @DisplayName("Follow shop")
    void followShop() {

        Company branch_kappl = new Branch("MehrRettich", "Kappl");
        Client marco = new Client("Marco","Cotrotzo",branch_kappl);
        Client jedin = new Client("Jedin","Müller",branch_kappl);
        Client mona = new Client("Mona", "Lisa", branch_kappl);
        branch_kappl.followShop(marco);
        assertEquals(branch_kappl.getCustomers().get(0),marco);
        branch_kappl.followShop(jedin);
        branch_kappl.followShop(mona);
        assertEquals(branch_kappl.getCustomers().size(),3);

    }


    @Test
    void messageEmptyCustomer() {
        Company branch_kappl = new Branch("MehrRettich", "Kappl");
        assertThrows(IllegalStateException.class, ()-> branch_kappl.messageCustomer(new Product(Category.FRUITS,"apple"),ProductState.NEW));

    }

    @Test
    void messageCustomer() {
        Company branch_kappl = new Branch("MehrRettich", "Kappl");
        Client marco = new Client("Marco","Cotrotzo",branch_kappl);
        Client jedin = new Client("Jedin","Müller",branch_kappl);
        Client mona = new Client("Mona", "Lisa", branch_kappl);
        branch_kappl.followShop(marco);
        branch_kappl.followShop(mona);
        branch_kappl.followShop(jedin);

        branch_kappl.messageCustomer(new Product(Category.FRUITS,"apple"),ProductState.NEW);
        branch_kappl.messageCustomer(new Product(Category.FRUITS,"banana"),ProductState.SOLDOUT);
        assertEquals(List.of("apple is NEW!","banana is SOLDOUT!"),marco.returnFeed());
    }
}